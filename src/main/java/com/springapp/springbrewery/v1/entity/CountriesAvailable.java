package com.springapp.springbrewery.v1.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountriesAvailable {

    @Id
    @GeneratedValue
    private Long countryId;

    @Column(nullable = false)
    private String countryName;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="beer_id", referencedColumnName = "id")
    private Beer beer;

}
