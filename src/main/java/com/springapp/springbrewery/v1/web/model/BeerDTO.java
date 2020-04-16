package com.springapp.springbrewery.v1.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    private Long id;
    private String name;
    private String beerStyle;
    private String upc;
    private String origin;


}
