package com.java.pink_closet.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchanges")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "return_id", nullable = false)
    private Return returnEntity;

    @ManyToOne
    @JoinColumn(name = "new_product_id", nullable = false)
    private Product newProduct;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private BigDecimal differenceAmount;

    @Enumerated(EnumType.STRING)
    private ExchangeStatus status;

    private LocalDateTime requestedAt;
    private LocalDateTime processedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}

