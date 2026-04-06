package session06.session06.model.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TicketResponse {
    private String id;
    private String licensePlate;
    private String zoneName;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime checkInTime;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime checkOutTime;
}
