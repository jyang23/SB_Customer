package com.jy.springboot_customer;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface CompanyRepository extends CrudRepository<Company,Long> {
    ArrayList<Company> findByCompany(String companyname);
}