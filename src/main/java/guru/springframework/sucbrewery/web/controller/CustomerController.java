package guru.springframework.sucbrewery.web.controller;

import guru.springframework.sucbrewery.service.CustomerService;
import guru.springframework.sucbrewery.web.model.BeerDto;
import guru.springframework.sucbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        var savedDto = customerService.saveNewCustomer(customerDto);
        var headers = new HttpHeaders();
        //todo add hostname to url
        headers.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
        if(customerService.updateCustomer(customerId, customerDto))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity deleteBeer(@PathVariable("customerId") UUID customerId){
        if(customerService.deleteCustomer(customerId))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
