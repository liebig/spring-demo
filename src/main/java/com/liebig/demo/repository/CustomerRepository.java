package com.liebig.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liebig.demo.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByLastName(String lastName);
}
