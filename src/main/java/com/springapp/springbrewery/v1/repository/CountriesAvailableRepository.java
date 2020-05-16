package com.springapp.springbrewery.v1.repository;

import com.springapp.springbrewery.v1.entity.CountriesAvailable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CountriesAvailableRepository extends JpaRepository<CountriesAvailable, Long> {
}
