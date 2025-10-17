package com.java.pink_closet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private Integer quantity;

    @Positive
    private BigDecimal unitPrice;

    @Positive
    private BigDecimal subtotal;

    @Enumerated(EnumType.STRING)
    private OrderItemStatus status = OrderItemStatus.PENDING;

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public void calculateSubtotal() {
        if (unitPrice != null && quantity != null) {
            this.subtotal = unitPrice.multiply(new BigDecimal(quantity));
        }
    }
}
