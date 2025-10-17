package com.java.pink_closet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String street;

    private String number;
    private String complement;
    private String neighborhood;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    private boolean primaryAddress;

    @NotBlank
    private String zipCode;

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
