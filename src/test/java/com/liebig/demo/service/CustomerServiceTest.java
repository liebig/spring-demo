package com.liebig.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liebig.demo.dto.CustomerDto;
import com.liebig.demo.entity.CustomerEntity;
import com.liebig.demo.repository.CustomerRepository;

/**
 * CustomerService Test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    /**
     * GetAllWithInsecurePassword Test.
     */
    @Test
    public void testGetAllWithInsecurePassword() {

        CustomerEntity customer1 = new CustomerEntity("Max", "Mustermann");
        customer1.setId(1L);
        customer1.setPassword("12345678");

        CustomerEntity customer2 = new CustomerEntity("Maxine", "Musterfrau");
        customer2.setId(2L);
        customer2.setPassword("123456789");

        CustomerEntity customer3 = new CustomerEntity("John", "Doe");
        customer3.setId(3L);
        customer3.setPassword("ABCDEFGH");

        CustomerEntity customer4 = new CustomerEntity("Foo", "Bar");
        customer4.setId(4L);
        customer4.setPassword("ABCDEFGHI");

        List<CustomerEntity> customers = Arrays.asList(customer1, customer2, customer3, customer4);

        Mockito.doReturn(customers).when(customerRepository).findAll();

        List<CustomerDto> insecureCustomers = customerService.getAllWithInsecurePassword();

        Assert.assertEquals(2, insecureCustomers.size());

        Assert.assertEquals(2L, insecureCustomers.get(0).getId());
        Assert.assertEquals("Maxine", insecureCustomers.get(0).getFirstName());
        Assert.assertEquals("Musterfrau", insecureCustomers.get(0).getLastName());

        Assert.assertEquals(4L, insecureCustomers.get(1).getId());
        Assert.assertEquals("Foo", insecureCustomers.get(1).getFirstName());
        Assert.assertEquals("Bar", insecureCustomers.get(1).getLastName());
    }

    /**
     * GetAllWithInsecurePassword Test without customers.
     */
    @Test
    public void testGetAllWithInsecurePasswordWithoutCustomers() {

        List<CustomerEntity> customers = Collections.emptyList();

        Mockito.doReturn(customers).when(customerRepository).findAll();

        List<CustomerDto> insecureCustomers = customerService.getAllWithInsecurePassword();

        Assert.assertEquals(0, insecureCustomers.size());
    }
}