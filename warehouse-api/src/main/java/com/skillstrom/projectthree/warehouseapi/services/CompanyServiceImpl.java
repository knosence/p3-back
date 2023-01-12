package com.skillstrom.projectthree.warehouseapi.services;

import com.skillstrom.projectthree.warehouseapi.models.Company;
import com.skillstrom.projectthree.warehouseapi.repositories.CompanyRepository;
import com.skillstrom.projectthree.warehouseapi.services.Interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }

    @Override
    public Company save(Company company) {
        if (!companyRepository.existsById(company.getCompanyId())) {
            return companyRepository.save(company);
        }
        return null;
    }

    @Override
    public Company update(Company company, int id) {
        if (companyRepository.existsById(id)) {
            company.setCompanyId(id);
            return companyRepository.save(company);
        }
        return null;
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public void deleteById(int id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
        } else {
            System.out.println("Company does not exist");
        }

    }
}
