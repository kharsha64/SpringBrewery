package com.springapp.springbrewery.v1.services;

import com.springapp.springbrewery.v1.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(Long beerId) {
        return BeerDTO.builder().id(20L).name("Corona").beerStyle("Pale Lager").upc("080660956800").build();
    }

    @Override
    public BeerDTO createBeer(BeerDTO beerDTO) {
        return BeerDTO.builder().id(45L).build();
    }

    @Override
    public void updateBeer(Long beerId, BeerDTO beerDTO) {
        log.debug("Updating the Beer");
    }

    @Override
    public void deleteBeer(Long beerId) {
        log.debug("Deleting the Beer");
    }
}
