package com.Globant.JobOffers.web.controller;

import com.Globant.JobOffers.domain.service.OfferServiceImpl;
import com.Globant.JobOffers.dto.OfferDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OfferController.class)
class OfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfferServiceImpl offerService;

    @Test
    void testGetAllOffers() throws Exception {
        OfferDto dto1 = new OfferDto();
        OfferDto dto2 = new OfferDto();

        List<OfferDto> offers = Arrays.asList(dto1, dto2);
        when(offerService.getAllOffers()).thenReturn(offers);

        mockMvc.perform(get("/api/offer/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testGetAllOffersFilter_withAllParams() throws Exception {
        OfferDto dto1 = new OfferDto();
        when(offerService.getAllOffersFilter(1L, 2L, true)).thenReturn(List.of(dto1));

        mockMvc.perform(get("/api/offer/filter")
                        .param("areaId", "1")
                        .param("cityId", "2")
                        .param("remote", "true"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void testGetAllOffersFilter_withNoParams() throws Exception {
        OfferDto dto1 = new OfferDto();
        OfferDto dto2 = new OfferDto();
        when(offerService.getAllOffersFilter(null, null, null)).thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/api/offer/filter"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testGetAllOffersFilter_onlyArea() throws Exception {
        OfferDto dto1 = new OfferDto();
        when(offerService.getAllOffersFilter(1L, null, null)).thenReturn(List.of(dto1));

        mockMvc.perform(get("/api/offer/filter")
                        .param("areaId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void testGetAllOffersFilter_onlyCity() throws Exception {
        OfferDto dto1 = new OfferDto();
        when(offerService.getAllOffersFilter(null, 2L, null)).thenReturn(List.of(dto1));

        mockMvc.perform(get("/api/offer/filter")
                        .param("cityId", "2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void testGetAllOffersFilter_onlyRemote() throws Exception {
        OfferDto dto1 = new OfferDto();
        when(offerService.getAllOffersFilter(null, null, true)).thenReturn(List.of(dto1));

        mockMvc.perform(get("/api/offer/filter")
                        .param("remote", "true"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void testGetAllOffersFilter_noResults() throws Exception {
        when(offerService.getAllOffersFilter(999L, 888L, false)).thenReturn(List.of());

        mockMvc.perform(get("/api/offer/filter")
                        .param("areaId", "999")
                        .param("cityId", "888")
                        .param("remote", "false"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(0));
    }
}
