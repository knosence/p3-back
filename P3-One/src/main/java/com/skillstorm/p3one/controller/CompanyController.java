package com.skillstorm.p3one.controller;

import com.skillstorm.p3one.entities.Company;
import com.skillstorm.p3one.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/company")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    final
    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public Iterable<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Company findById(@PathVariable("id") int id) {
        return companyService.findById(id);
    }

    @PostMapping
    public Company save(@RequestBody Company company) {
        return companyService.save(company);
    }

    @PutMapping(value = "/{id}")
    public Company update(@RequestBody Company company, @PathVariable("id") int id) {
        return companyService.update(company, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        companyService.deleteById(id);
    }


}
