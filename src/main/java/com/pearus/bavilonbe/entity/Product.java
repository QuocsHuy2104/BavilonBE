package com.pearus.bavilonbe.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    String code;

    @Column(nullable = false, length = 255)
    String name;

    @Column(nullable = false)
    float price;

    @Column(nullable = false)
    int quantity;

    @Column(columnDefinition = "TEXT")
    String description;

    @Column(nullable = false)
    int sold;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_name")
    Category category;

    @ManyToOne
    @JoinColumn(name = "brand_name")
    Brand brand;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    Set<Image> images;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private Set<Cart> carts;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private Set<FlashSale> flashSales;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private Set<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "layout_layout")
    private Layout layout;

}
