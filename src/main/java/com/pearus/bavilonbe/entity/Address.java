package com.pearus.bavilonbe.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullName", columnDefinition = "nvarchar(100)")
    @Nationalized
    private String fullName;

    @Column
    private String numberPhone;

    @Column
    private boolean isDelete;

    @Nationalized
    private String provinceID;

    @Nationalized
    private String districtCode;

    @Nationalized
    private String wardCode;

    @Nationalized
    private String address;

    @Column
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "address", orphanRemoval = true)
    private Set<Order> orders = new LinkedHashSet<>();

}
