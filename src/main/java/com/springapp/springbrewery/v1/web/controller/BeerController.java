package com.springapp.springbrewery.v1.web.controller;

import com.springapp.springbrewery.v1.services.BeerService;
import com.springapp.springbrewery.v1.web.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") Long beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createNewBeer(@RequestBody BeerDTO beerDTO, UriComponentsBuilder uriComponentsBuilder) {
        BeerDTO savedBeer = beerService.createBeer(beerDTO);
        /*HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/"+savedBeer.getId().toString());
        headers.add("IDE", "IntelliJ");*/

        UriComponents uriComponents = uriComponentsBuilder.path("/api/v1/beer/{id}").buildAndExpand(savedBeer.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        headers.add("IDE", "IntelliJ");

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId") Long beerId, @RequestBody BeerDTO beerDTO) {
        beerService.updateBeer(beerId, beerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") Long beerId) {
        beerService.deleteBeer(beerId);
    }

}
