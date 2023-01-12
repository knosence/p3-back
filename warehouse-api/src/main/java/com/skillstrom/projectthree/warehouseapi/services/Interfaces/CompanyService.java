package com.skillstrom.projectthree.warehouseapi.services.Interfaces;

import com.skillstrom.projectthree.warehouseapi.models.Company;

public interface CompanyService {

        Iterable<Company> findAll();

        Company findById(int id);

        Company save(Company company);

        Company update(Company company, int id);

        void delete(Company company);

        void deleteById(int id);

}
