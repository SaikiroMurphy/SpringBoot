package session06.session06.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import session06.session06.model.dto.response.TicketSummaryResponse;
import session06.session06.model.entity.ParkingTicket;

public interface IParkingTicketRepository extends JpaRepository<ParkingTicket, String>{
    @Query("""
            SELECT new session06.session06.model.dto.response.TicketSummaryResponse(
                t.id,
                t.vehicle.licensePlate,
                t.zone.name,
                t.checkInTime,
                t.checkOutTime)
            FROM ParkingTicket t
            WHERE (t.checkInTime >= :start AND t.checkInTime < :end)
            OR (t.checkOutTime >= :start AND t.checkOutTime < :end)
            """)
    List<TicketSummaryResponse> getSummaryToday(LocalDateTime start, LocalDateTime end);
}
