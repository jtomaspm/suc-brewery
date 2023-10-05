package guru.springframework.sucbrewery.service;

import guru.springframework.sucbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    public CustomerDto getCustomerById(UUID customerId);
}
