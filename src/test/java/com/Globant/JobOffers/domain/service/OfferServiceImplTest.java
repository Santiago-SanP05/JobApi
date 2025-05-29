package com.Globant.JobOffers.domain.service;

import com.Globant.JobOffers.domain.repository.OfferRepository;
import com.Globant.JobOffers.dto.OfferDto;
import com.Globant.JobOffers.persistence.entity.Offer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OfferServiceImplTest {

    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private OfferServiceImpl offerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllOffers() {
        Offer offer1 = mock(Offer.class);
        Offer offer2 = mock(Offer.class);
        OfferDto dto1 = new OfferDto(); // puedes asignar atributos si quieres verificar luego
        OfferDto dto2 = new OfferDto();

        when(offer1.toDTO()).thenReturn(dto1);
        when(offer2.toDTO()).thenReturn(dto2);
        when(offerRepository.findAllOffersActive()).thenReturn(Arrays.asList(offer1, offer2));

        List<OfferDto> result = offerService.getAllOffers();

        assertEquals(2, result.size());
        verify(offerRepository, times(1)).findAllOffersActive();
    }

    @Test
    void testGetAllOffersFilter() {
        Long areaId = 1L;
        Long cityId = 2L;
        Boolean remote = true;

        Offer offer1 = mock(Offer.class);
        OfferDto dto1 = new OfferDto();
        when(offer1.toDTO()).thenReturn(dto1);

        when(offerRepository.findAllOffers(areaId, cityId, remote)).thenReturn(List.of(offer1));

        List<OfferDto> result = offerService.getAllOffersFilter(areaId, cityId, remote);

        assertEquals(1, result.size());
        verify(offerRepository, times(1)).findAllOffers(areaId, cityId, remote);
    }
}
