package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Company;
import com.skillstorm.p3one.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    final
    CompanyRepository companyRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public Iterable<Company> findAll() {
        Iterable<Company> companies = companyRepository.findAll();
        logger.info("Found {} companies", companies.spliterator().getExactSizeIfKnown());
        return companies;
    }

    @Override
    public Company findById(int id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        logger.info("Found company {}", company);
        return company;
    }

    @Override
    public Company save(Company company) {
        Company company1 = companyRepository.save(company);
        logger.info("Saved company {}", company1);
        return company1;
    }

    @Override
    public void deleteById(int id) {
        companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        companyRepository.deleteById(id);
        logger.info("Deleted company with id {}", id);
    }

    @Override
    public Company update(Company company, int id) {

        Company company1 = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));

        company1.setId(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocation(company.getLocation());
        company1.setWarehouses(company.getWarehouses());
        logger.info("Updated company {}", company1);

        return companyRepository.save(company1);

    }


}
