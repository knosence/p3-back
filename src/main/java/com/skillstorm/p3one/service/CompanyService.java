package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Company;

public interface CompanyService {

    Iterable<Company> findAll();

    Company findById(int id);

    Company save(Company company);

    void deleteById(int id);

    Company update(Company company, int id);


}
