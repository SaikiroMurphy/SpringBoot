package session06.session06;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import session06.session06.model.entity.ParkingTicket;
import session06.session06.model.entity.Vehicle;
import session06.session06.model.entity.Zone;
import session06.session06.repository.IParkingTicketRepository;
import session06.session06.repository.IVehicleRepository;
import session06.session06.repository.IZoneRepository;
import session06.session06.utils.VehicleType;

@SpringBootApplication
public class Session06Application {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
		SpringApplication.run(Session06Application.class, args);
	}

	@Bean
	CommandLineRunner initData(
			IVehicleRepository vehicleRepo,
			IZoneRepository zoneRepo,
			IParkingTicketRepository ticketRepo
	) {
		return args -> {
			if (vehicleRepo.count() > 0 || zoneRepo.count() > 0 || ticketRepo.count() > 0) {
				return;
			}

			// ===== 1. ZONE =====
			List<Zone> zones = new ArrayList<>();
			for (int i = 1; i <= 5; i++) {
				Zone zone = new Zone();
				zone.setName("Zone " + i);
				zone.setCapacity(10);
				zone.setOccupiedSpots(0);
				zones.add(zone);
			}
			zones = zoneRepo.saveAll(zones);

			// ===== 2. VEHICLE =====
			List<Vehicle> vehicles = new ArrayList<>();
			VehicleType[] types = VehicleType.values();

			for (int i = 1; i <= 10; i++) {
				Vehicle vehicle = new Vehicle();
				vehicle.setLicensePlate("29A-" + (10000 + i));
				vehicle.setColor("Color-" + i);
				vehicle.setType(types[i % types.length]);
				vehicles.add(vehicle);
			}
			vehicles = vehicleRepo.saveAll(vehicles);

			// ===== 3. PARKING TICKET =====
			List<ParkingTicket> tickets = new ArrayList<>();

			for (int i = 0; i < vehicles.size(); i++) {
				Vehicle vehicle = vehicles.get(i);

				for (int j = 0; j < 3; j++) {

					Zone zone = zones.get((i * 3 + j) % zones.size());

					ParkingTicket ticket = new ParkingTicket();

					ticket.setVehicle(vehicle);
					ticket.setZone(zone);

					ticket.setCheckInTime(LocalDateTime.now().minusHours(i + j));

					// 50% có checkout
					if ((i + j) % 2 == 0) {
						ticket.setCheckOutTime(LocalDateTime.now().plusHours(j + 1));
					}

					tickets.add(ticket);
				}
			}

			ticketRepo.saveAll(tickets);

			// ===== 4. UPDATE OCCUPIED (TRÁNH LỖI LOCKING) =====
			Map<String, Integer> countMap = new HashMap<>();

			for (ParkingTicket t : tickets) {
				if (t.getCheckOutTime() == null) { // chỉ tính xe đang đỗ
					String zoneId = t.getZone().getId();
					countMap.put(zoneId, countMap.getOrDefault(zoneId, 0) + 1);
				}
			}

			for (Zone z : zones) {
				z.setOccupiedSpots(countMap.getOrDefault(z.getId(), 0));
			}
			zoneRepo.saveAll(zones);
		};
	}
}
