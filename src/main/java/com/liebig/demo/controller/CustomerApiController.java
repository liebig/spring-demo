package com.liebig.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liebig.demo.dto.CustomerDto;
import com.liebig.demo.exception.NotFoundException;
import com.liebig.demo.service.CustomerService;

@RequestMapping("/api/customers")
@RestController
public class CustomerApiController {

    private final CustomerService customerService;

    public CustomerApiController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<CustomerDto> getAll() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/lastname={lastname}")
    public List<CustomerDto> getByLastname(@PathVariable("lastname") String lastname) {
        return customerService.getAllByLastName(lastname);
    }

    @GetMapping("/insecure")
    public List<CustomerDto> getAllInsecure() {
        return customerService.getAllWithInsecurePassword();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) throws NotFoundException {
        customerService.removeById(id);
    }

}
