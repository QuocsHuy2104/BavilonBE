package com.pearus.bavilonbe.repository;

import com.pearus.bavilonbe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
