package guru.springframework.sucbrewery.service;

import guru.springframework.sucbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceSimpleImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .id(id)
                .name("John Doe")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customerDto.getName())
                .build();
    }

    @Override
    public boolean updateCustomer(UUID customerId, CustomerDto customerDto) {
        return getCustomerById(customerId) != null;
    }

    @Override
    public boolean deleteCustomer(UUID customerId) {
        return getCustomerById(customerId) != null;
    }
}
