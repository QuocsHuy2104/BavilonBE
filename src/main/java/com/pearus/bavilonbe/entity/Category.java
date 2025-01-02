package com.pearus.bavilonbe.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    String name;
    String url;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    List<Product> products;
}
