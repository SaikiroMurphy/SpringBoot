package session06.session06.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ZoneResponse {
    private String id;
    private String name;
    private int capacity;
    private int occupiedSpots;
}
