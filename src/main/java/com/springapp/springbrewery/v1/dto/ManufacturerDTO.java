package com.springapp.springbrewery.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManufacturerDTO {
    private Long id;
    private String name;
    private String batch_number;
}
