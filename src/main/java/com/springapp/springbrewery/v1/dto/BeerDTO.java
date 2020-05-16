package com.springapp.springbrewery.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    private Long id;
    private String name;
    private BeerStyleEnum beerStyle;
    private String upc;

    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime modifiedDate;

    private List<CountriesAvailableDTO> countriesAvailableDTOList;

    private ManufacturerDTO manufacturer;

}
