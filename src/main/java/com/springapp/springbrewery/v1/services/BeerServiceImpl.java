package com.springapp.springbrewery.v1.services;

import com.springapp.springbrewery.v1.dto.BeerDTO;
import com.springapp.springbrewery.v1.dto.BeerStyleEnum;
import com.springapp.springbrewery.v1.dto.CountriesAvailableDTO;
import com.springapp.springbrewery.v1.dto.ManufacturerDTO;
import com.springapp.springbrewery.v1.entity.Beer;
import com.springapp.springbrewery.v1.entity.CountriesAvailable;
import com.springapp.springbrewery.v1.entity.Manufacturer;
import com.springapp.springbrewery.v1.repository.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerRepository beerRepository;

    /*@Autowired
    private SessionFactory sessionFactory;*/

    @Override
    public BeerDTO getBeerById(Long beerId) {
        //return BeerDTO.builder().id(20L).name("Corona").beerStyle(BeerStyleEnum.IPA).upc("080660956800").build();
        //return BeerDTO.builder().id(20L).name("Corona").beerStyle(BeerStyleEnum.IPA).upc("080660956800").build();
        return copyBeerToBeerDTO(beerRepository.getOne(beerId));
    }

    @Override
    public BeerDTO createBeer(BeerDTO dto) {
        Beer beer = copyBeerDtoToBeer(dto);
        //sessionFactory.getCurrentSession().save(beer);
        //log.info("Persisting Entity : {}", beer);
        return copyBeerToBeerDTO(beerRepository.save(beer));
        //return dto;
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
        List<CountriesAvailableDTO> countriesAvailableDTOS = new ArrayList<>();
        dto.setId(beer.getId());
        dto.setBeerStyle(BeerStyleEnum.valueOf(beer.getBeerStyle()));
        dto.setName(beer.getName());
        dto.setUpc(beer.getUpc());
        dto.setVersion(beer.getVersion());
        dto.setCreatedDate(beer.getCreatedDate());
        dto.setModifiedDate(beer.getModifiedDate());

        for (CountriesAvailable countriesAvailable : beer.getCountriesAvailable()) {
            CountriesAvailableDTO cDto = new CountriesAvailableDTO();
            cDto.setCountryName(countriesAvailable.getCountryName());
            cDto.setPrice(countriesAvailable.getPrice());
            cDto.setId(countriesAvailable.getCountryId());
            countriesAvailableDTOS.add(cDto);
        }

        ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
        manufacturerDTO.setBatch_number(beer.getManufacturer().getBatch_number());
        manufacturerDTO.setName(beer.getManufacturer().getName());
        manufacturerDTO.setId(beer.getManufacturer().getId());
        dto.setManufacturer(manufacturerDTO);
        dto.setCountriesAvailableDTOList(countriesAvailableDTOS);

        return dto;
    }

    private Beer copyBeerDtoToBeer(BeerDTO beerDTO) {
        Beer beer = new Beer();
        List<CountriesAvailable> countriesAvailableList = new ArrayList<>();

        beer.setId(beerDTO.getId());
        beer.setBeerStyle(beerDTO.getBeerStyle().name());
        beer.setName(beerDTO.getName());

        beer.setUpc(beerDTO.getUpc());
        beer.setVersion(beerDTO.getVersion());
        beer.setCreatedDate(OffsetDateTime.now());
        beer.setModifiedDate(OffsetDateTime.now());

        for (CountriesAvailableDTO countriesAvailableDTO : beerDTO.getCountriesAvailableDTOList()) {
            CountriesAvailable countriesAvailable = new CountriesAvailable();
            countriesAvailable.setCountryName(countriesAvailableDTO.getCountryName());
            countriesAvailable.setPrice(countriesAvailableDTO.getPrice());
            countriesAvailable.setBeer(beer);
            countriesAvailableList.add(countriesAvailable);
        }
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setBatch_number(beerDTO.getManufacturer().getBatch_number());
        manufacturer.setName(beerDTO.getManufacturer().getName());
        manufacturer.setBeer(beer);
        beer.setManufacturer(manufacturer);
        beer.setCountriesAvailable(countriesAvailableList);

        return beer;
    }
}
