package com.java.pink_closet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private BigDecimal amount;

    private String method;

    private String status;

    private LocalDateTime paymentDate;

    // Relacionamento com Order
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
