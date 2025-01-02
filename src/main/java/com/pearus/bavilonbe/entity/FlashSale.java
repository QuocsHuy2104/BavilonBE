package com.pearus.bavilonbe.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "FlashSales")
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants(level = AccessLevel.PRIVATE)
public class FlashSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "original_price", nullable = false)
    BigDecimal originalPrice;

    @Column(name = "start_date", columnDefinition = "DATETIME")
    LocalDateTime startDate;

    @Column(name = "end_date", columnDefinition = "DATETIME")
    LocalDateTime endDate;

    @Column(name = "discount_price", nullable = false)
    BigDecimal discountPrice;

    @Column(name = "discount_percentage", nullable = false)
    Integer discountPercentage;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    FlashSaleStatus status;

    @ManyToOne
    @JoinColumn(name = "product_code")
    private Product product;

    public enum FlashSaleStatus {
        UPCOMING,    // Flash Sale sắp diễn ra
        ONGOING,     // Flash Sale đang diễn ra
        ENDED,       // Flash Sale đã kết thúc
        CANCELLED    // Flash Sale bị hủy
    }
}
