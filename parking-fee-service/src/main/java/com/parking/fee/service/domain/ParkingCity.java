package com.parking.fee.service.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "parking_city")
public class ParkingCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JsonBackReference
    private List<WeekdayParkingFeeRule> weekdayParkingFeeRules = new ArrayList<>();
    @OneToMany(mappedBy = "city", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<ParkedData> parkedData = new HashSet<>();
}
