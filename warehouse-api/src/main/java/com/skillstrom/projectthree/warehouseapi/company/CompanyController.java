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
        return companyService.getById(id);
    }

    @PutMapping("/{id}")
    public Company update(@RequestBody Company company, @PathVariable int id) {
        return companyService.update(company, id);
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        return companyService.create(company);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        companyService.deleteById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Company company) {
        companyService.delete(company);
    }
}
