package com.dockersamples.catalogservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String upc;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "has_image")
    private boolean hasImage;

    // This field is not stored in the database, but populated from the inventory service
    @Transient
    private Integer inventory;
}
