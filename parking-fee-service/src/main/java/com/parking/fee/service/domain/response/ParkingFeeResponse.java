package com.parking.fee.service.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ParkingFeeResponse {
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalFee;
    private Map<LocalDate, Double> summary;
}
