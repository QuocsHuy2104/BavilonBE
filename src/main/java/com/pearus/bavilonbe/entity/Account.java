package com.pearus.bavilonbe.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String email;
    String fullName;
    String password;
    String picture;

    @OneToMany(mappedBy = "account", orphanRemoval = true)
    private List<Cart> carts;

    @OneToMany(mappedBy = "account", orphanRemoval = true)
    private Set<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "role_role")
    private Role role;

}
