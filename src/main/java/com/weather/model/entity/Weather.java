package com.weather.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "weather")
@Builder(toBuilder = true)
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double temperature;
    private Double wind;
    private Double pressure;
    private Double humidity;
    private String  conditions;
    private String  location;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
