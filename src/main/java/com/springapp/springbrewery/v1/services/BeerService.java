package com.springapp.springbrewery.v1.services;

import com.springapp.springbrewery.v1.dto.BeerDTO;
import com.springapp.springbrewery.v1.entity.Beer;

public interface BeerService {
    BeerDTO getBeerById(Long beerId);

    BeerDTO createBeer(BeerDTO beer);

    void updateBeer(Long beerId, BeerDTO beerDTO);

    void deleteBeer(Long beerId);
}
