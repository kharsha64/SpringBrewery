package com.springapp.springbrewery.v1.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Beer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name="TYPE", nullable = false)
    private String beerStyle;

    @Column(nullable = false)
    private String upc;

    @Column(nullable = false)
    private Integer version;

    @Column(name="CREATED_DATE", nullable = false)
    private OffsetDateTime createdDate;

    @Column(name="MODIFIED_DATE")
    private OffsetDateTime modifiedDate;

    @OneToMany(mappedBy = "beer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CountriesAvailable> countriesAvailable;

    @OneToOne(mappedBy = "beer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Manufacturer manufacturer;
}
