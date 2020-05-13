package com.springapp.springbrewery.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
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

    @Column(nullable = false)
    private BigDecimal price;
}
