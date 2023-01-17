package com.skillstrom.projectthree.warehouseapi.company;

import com.skillstrom.projectthree.warehouseapi.company.Company;

public interface CompanyService {

        Iterable<Company> getAllCompanies();

        Company getCompanyById(int id);

        Company updateCompany(Company company, int id);

        Company createCompany(Company company);

        void deleteCompany(Company company);

        void deleteCompanyById(int id);


}
