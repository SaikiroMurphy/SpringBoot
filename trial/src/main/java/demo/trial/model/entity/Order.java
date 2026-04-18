package session11.session11.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;
import session11.session11.utils.OrderStatusEnum;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(precision = 12, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    private String shippingAddress;

    private String note;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
