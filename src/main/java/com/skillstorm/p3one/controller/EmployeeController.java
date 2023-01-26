package com.skillstorm.p3one.controller;

import com.skillstorm.p3one.entities.Employee;
import com.skillstorm.p3one.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    final
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Iterable<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Employee findById(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping(value = "/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable("id") int id) {
        return employeeService.update(employee, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        employeeService.deleteById(id);
    }


}
