package com.springapp.springbrewery.v1.repository;

import com.springapp.springbrewery.v1.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {


}
