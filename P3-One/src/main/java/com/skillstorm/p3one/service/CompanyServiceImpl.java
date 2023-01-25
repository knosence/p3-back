package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Company;
import com.skillstorm.p3one.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Primary
@Transactional
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
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int id) {
        //Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        //logger.info("Found company {}", company);
        //return company;

        Optional<Company> company = companyRepository.findById(id);
        return company.isPresent() ? company.get() : null;

    }

    @Override
    public Company save(Company company) {
        //Company company1 = companyRepository.save(company);
        //logger.info("Saved company {}", company1);
        //return company1;

        return companyRepository.save(company);
    }

    @Override
    public void deleteById(int id) {
        //companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        //companyRepository.deleteById(id);
        //logger.info("Deleted company with id {}", id);

        companyRepository.deleteById(id);
    }

    @Override
    public Company update(Company company, int id) {
        company.setId(id);
        return companyRepository.save(company);

    }


}
