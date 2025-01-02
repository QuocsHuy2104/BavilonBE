package com.pearus.bavilonbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class InvalidToken {
    @Id
    String id;

    @Temporal(TemporalType.TIMESTAMP)  // Ensure it maps correctly to DATETIME or TIMESTAMP in MySQL
    private Date expiryTime;
}