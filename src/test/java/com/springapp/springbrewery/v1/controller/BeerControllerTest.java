package com.springapp.springbrewery.v1.controller;

import com.springapp.springbrewery.v1.services.BeerService;
import com.springapp.springbrewery.v1.dto.BeerDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeerDTO beerDTO;

  /*  @Captor
    private ArgumentCaptor<BeerDTO> createArgumentCaptor;

    @Captor
    private ArgumentCaptor<Long> getArgumentCaptor;
*/
    @MockBean
    private BeerService beerService;

    @Test
    void getBeerById() throws Exception {

        /*BeerDTO beerDTO = new BeerDTO();
        beerDTO.setId(23L);
        beerDTO.setBeerStyle("ALE");
        beerDTO.setName("Corona");
        beerDTO.setPrice(new BigDecimal(29));
        beerDTO.setUpc("080660956800");
        beerDTO.setVersion(1);
        beerDTO.setCreatedDate(OffsetDateTime.now());
        beerDTO.setModifiedDate(OffsetDateTime.now());

        when(beerService.getBeerById(getArgumentCaptor.capture())).thenReturn(beerDTO);*/

        when(beerService.getBeerById(Mockito.anyLong())).thenReturn(beerDTO);

        mockMvc.perform(get("/api/v1/beer/" + 23L).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void createNewBeer() {
    }

    @Test
    void updateBeerById() {
    }

    @Test
    void deleteBeerById() {
    }
}