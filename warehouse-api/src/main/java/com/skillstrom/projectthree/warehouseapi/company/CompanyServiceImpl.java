package com.skillstrom.projectthree.warehouseapi.company;

import com.skillstrom.projectthree.warehouseapi.company.Company;
import com.skillstrom.projectthree.warehouseapi.company.CompanyRepository;
import com.skillstrom.projectthree.warehouseapi.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Iterable<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(int id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }

    @Override
    public Company updateCompany(Company company, int id) {
        Optional<Company> company1 = companyRepository.findById(id);
        if (!company1.isPresent()) {
            return null;
        }
        company.setCompanyId(id);
        return companyRepository.save(company);
    }

    @Override
    public Company createCompany(Company company) {
        return null;
    }

    @Override
    public void deleteCompany(Company company) {

    }

    @Override
    public void deleteCompanyById(int id) {

    }
}
