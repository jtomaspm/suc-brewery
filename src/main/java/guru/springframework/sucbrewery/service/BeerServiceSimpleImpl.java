package guru.springframework.sucbrewery.service;

import guru.springframework.sucbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceSimpleImpl implements BeerService {
    @Override
    public BeerDto getBeer(UUID beerId) {
        return BeerDto.builder()
                .id(beerId)
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(123456789012L)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public boolean updateBeer(UUID beerId, BeerDto beerDto) {
        return getBeer(beerId) != null;
    }

    @Override
    public boolean deleteBeer(UUID beerId) {
        return getBeer(beerId) != null;
    }
}
