package guru.springframework.sucbrewery.service;

import guru.springframework.sucbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeer(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    boolean updateBeer(UUID beerId, BeerDto beerDto);

    boolean deleteBeer(UUID beerId);
}
