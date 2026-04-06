package session06.session06.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import session06.session06.model.dto.request.TicketRequest;
import session06.session06.model.dto.response.TicketResponse;
import session06.session06.model.dto.response.TicketSummaryResponse;
import session06.session06.model.entity.ParkingTicket;
import session06.session06.model.entity.Vehicle;
import session06.session06.model.entity.Zone;
import session06.session06.repository.IParkingTicketRepository;
import session06.session06.repository.IVehicleRepository;
import session06.session06.repository.IZoneRepository;

@Service
@RequiredArgsConstructor
public class ParkingService {
    private final IParkingTicketRepository parkingRepository;
    private final IZoneRepository zoneRepository;
    private final IVehicleRepository vehicleRepository;

    @Transactional
    public TicketResponse checkIn(TicketRequest req) {
        Zone zone = zoneRepository.findById(req.getZoneId()).orElseThrow(() -> new RuntimeException("Bãi đỗ xe không tồn tại!"));
        Vehicle vehicle =vehicleRepository.findById(req.getVehicleId()).orElseThrow(() -> new RuntimeException("Xe không tồn tại!"));

        if (zone.getCapacity() <= zone.getOccupiedSpots()) {
            throw new RuntimeException("Bãi đỗ xe không còn chỗ trống!");
        }

        ParkingTicket ticket = new ParkingTicket();
        ticket.setZone(zone);
        ticket.setVehicle(vehicle);
        ticket.setCheckInTime(LocalDateTime.now());
        parkingRepository.save(ticket);

        zone.setOccupiedSpots(zone.getOccupiedSpots() + 1);
        zoneRepository.save(zone);

        return new TicketResponse(
            ticket.getId(),
            ticket.getVehicle().getLicensePlate(),
            ticket.getZone().getName(),
            ticket.getCheckInTime(),
            ticket.getCheckOutTime());
    }

    @Transactional
    public TicketResponse checkOut(String vehicleId) {
        ParkingTicket ticket = parkingRepository.findAll().stream().max(Comparator.comparing(ParkingTicket::getCheckInTime))
                .orElseThrow(() -> new RuntimeException("Tìm thẻ đỗ xe thất bại!"));
        Zone zone = ticket.getZone();
        ticket.setCheckOutTime(LocalDateTime.now());
        parkingRepository.save(ticket);

        zone.setOccupiedSpots(zone.getOccupiedSpots() - 1);
        zoneRepository.save(zone);

        return new TicketResponse(
                ticket.getId(),
                ticket.getVehicle().getLicensePlate(),
                ticket.getZone().getName(),
                ticket.getCheckInTime(),
                ticket.getCheckOutTime());

    }

    public List<TicketSummaryResponse> getSummaryToday() {
        LocalDate today = LocalDate.now();

        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        return parkingRepository.getSummaryToday(start, end);
    }
}
