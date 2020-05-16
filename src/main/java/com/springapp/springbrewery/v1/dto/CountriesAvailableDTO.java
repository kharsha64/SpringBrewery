package com.springapp.springbrewery.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountriesAvailableDTO {
    private Long id;
    private String countryName;
    private BigDecimal price;
}
