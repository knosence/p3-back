package com.skillstrom.projectthree.warehouseapi.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {


    @Autowired
    private CompanyService companyService;

    @GetMapping
    public Iterable<Company> findAll() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public Company update(@RequestBody Company company, @PathVariable int id) {
        return companyService.updateCompany(company, id);
    }

    @PostMapping
    public Company save(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        companyService.deleteCompanyById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Company company) {
        companyService.deleteCompany(company);
    }
}
