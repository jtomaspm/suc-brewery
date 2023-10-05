package guru.springframework.sucbrewery.service;

import guru.springframework.sucbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
