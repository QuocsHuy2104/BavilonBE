package com.pearus.bavilonbe.repository;

import com.pearus.bavilonbe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
