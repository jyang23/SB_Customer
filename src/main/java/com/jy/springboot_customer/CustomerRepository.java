package com.jy.springboot_customer;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    ArrayList<Customer> findByTitle(String title);
    ArrayList<Customer> findByFirstname(String firstname);
    ArrayList<Customer> findByLastname(String lastname);
    ArrayList<Customer> findByCity(String city);
    ArrayList<Customer> findByState(String state);
    ArrayList<Customer> findByZipcode(String zipcode);
    ArrayList<Customer> findById(String id);
}