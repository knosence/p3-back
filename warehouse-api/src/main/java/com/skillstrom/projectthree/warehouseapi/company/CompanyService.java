package com.skillstrom.projectthree.warehouseapi.company;

public interface CompanyService {

    Iterable<Company> getAllCompanies();

    Company getById(int id);

    Company update(Company company, int id);

    Company create(Company company);

    void delete(Company company);

    void deleteById(int id);


}
