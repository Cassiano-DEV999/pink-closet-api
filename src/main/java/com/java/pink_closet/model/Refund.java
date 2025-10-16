package com.java.pink_closet.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "refunds")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "return_id", nullable = false)
    private Return returnEntity;

    @Enumerated(EnumType.STRING)
    private RefundMethod method;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private RefundStatus status;

    private LocalDateTime processedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
