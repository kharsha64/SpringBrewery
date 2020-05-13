package com.springapp.springbrewery.v1.services;

import com.springapp.springbrewery.v1.dto.BeerDTO;
import com.springapp.springbrewery.v1.dto.BeerStyleEnum;
import com.springapp.springbrewery.v1.entity.Beer;
import com.springapp.springbrewery.v1.repository.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerRepository beerRepository;

    @Override
    public BeerDTO getBeerById(Long beerId) {
        //return BeerDTO.builder().id(20L).name("Corona").beerStyle(BeerStyleEnum.IPA).upc("080660956800").build();
        //return BeerDTO.builder().id(20L).name("Corona").beerStyle(BeerStyleEnum.IPA).upc("080660956800").build();
        return copyBeerToBeerDTO(beerRepository.getOne(beerId));
    }

    @Override
    public BeerDTO createBeer(BeerDTO dto) {
        Beer beer = copyBeerDtoToBeer(dto);
        return copyBeerToBeerDTO(beerRepository.save(beer));
    }

    @Override
    public void updateBeer(Long beerId, BeerDTO beerDTO) {

        log.debug("Updating the Beer");
        beerDTO.setId(beerId);
        beerRepository.save(copyBeerDtoToBeer(beerDTO));

    }

    @Override
    public void deleteBeer(Long beerId) {

        log.debug("Deleting the Beer");
        beerRepository.deleteById(beerId);
    }


    private BeerDTO copyBeerToBeerDTO(Beer beer) {
        BeerDTO dto = new BeerDTO();
        dto.setId(beer.getId());
        dto.setBeerStyle(BeerStyleEnum.valueOf(beer.getBeerStyle()));
        dto.setName(beer.getName());
        dto.setPrice(beer.getPrice());
        dto.setUpc(beer.getUpc());
        dto.setVersion(beer.getVersion());
        dto.setCreatedDate(beer.getCreatedDate());
        dto.setModifiedDate(beer.getModifiedDate());
        return dto;
    }

    private Beer copyBeerDtoToBeer(BeerDTO beerDTO) {
        Beer beer = new Beer();
        beer.setId(beerDTO.getId());
        beer.setBeerStyle(beerDTO.getBeerStyle().name());
        beer.setName(beerDTO.getName());
        beer.setPrice(beerDTO.getPrice());
        beer.setUpc(beerDTO.getUpc());
        beer.setVersion(beerDTO.getVersion());
        beer.setCreatedDate(OffsetDateTime.now());
        beer.setModifiedDate(OffsetDateTime.now());
        return beer;
    }
}
