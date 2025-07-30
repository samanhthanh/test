package com.example.test.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_view")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "image")
    private String image;

    private String description;
    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;
}
