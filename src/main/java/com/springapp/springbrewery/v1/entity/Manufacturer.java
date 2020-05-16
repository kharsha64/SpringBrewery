package com.springapp.springbrewery.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String batch_number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="beer_id", referencedColumnName = "id")
    private Beer beer;
}
