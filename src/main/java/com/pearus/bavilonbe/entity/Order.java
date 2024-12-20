package com.pearus.bavilonbe.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    String code;
    LocalDate orderDate;
    float shippingFee;
    String payStatus;
    float amount;
    int quantity;
    String fullAddress;
    String fullName;
    String email;
    String phone;
    String cancelReason;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
