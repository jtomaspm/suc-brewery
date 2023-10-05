package guru.springframework.sucbrewery.web.controller;

import guru.springframework.sucbrewery.service.BeerService;
import guru.springframework.sucbrewery.web.model.BeerDto;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId")UUID beerId){
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> handlePost(@RequestBody BeerDto beerDto){
        return new ResponseEntity<Object>(
                new Object(){
                    public String message = "Success";
                },
                HttpStatus.CREATED);
    }
}
