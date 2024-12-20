package com.pearus.bavilonbe.repository;

import com.pearus.bavilonbe.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
