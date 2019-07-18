package com.liebig.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.liebig.demo.dto.CustomerDto;
import com.liebig.demo.entity.CustomerEntity;
import com.liebig.demo.exception.NotFoundException;
import com.liebig.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Get all customer.
     *
     * @return List of CustomerDto
     */
    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll().stream().map(this::map).collect(Collectors.toList());

    }

    public List<CustomerDto> getAllByLastName(String lastName) {
        return customerRepository.findByLastName(lastName).stream().map(this::map).collect(Collectors.toList());
    }

    public List<CustomerDto> getAllWithInsecurePassword() {
        return customerRepository.findAll().stream()
                .filter(customerEntity -> StringUtils.length(customerEntity.getPassword()) > 8).map(this::map)
                .collect(Collectors.toList());
    }

    public void removeById(long id) throws NotFoundException {
        if (!customerRepository.existsById(id)) {
            throw new NotFoundException(String.format("Could not find Customer with ID '%s' for deletion", id));
        }

        customerRepository.deleteById(id);
    }

    private CustomerDto map(CustomerEntity customerEntity) {
        return new CustomerDto(customerEntity.getId(), customerEntity.getFirstName(), customerEntity.getLastName());
    }

}
