package session12.session12.model.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SupplyResponse {
    private Long id;

    private String name;

    private String specification;

    private String unit;

    private Integer quantity;

    private String provider;
}
