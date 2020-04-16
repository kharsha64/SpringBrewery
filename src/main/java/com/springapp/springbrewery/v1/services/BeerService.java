package com.springapp.springbrewery.v1.services;

import com.springapp.springbrewery.v1.web.model.BeerDTO;

public interface BeerService {
    BeerDTO getBeerById(Long beerId);

    BeerDTO createBeer(BeerDTO beerDTO);

    void updateBeer(Long beerId, BeerDTO beerDTO);

    void deleteBeer(Long beerId);
}
