package com.skillstrom.projectthree.warehouseapi.company;

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
    public Company getById(int id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
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
    public Company create(Company company) {
        return companyRepository.save(company);

    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }
}
