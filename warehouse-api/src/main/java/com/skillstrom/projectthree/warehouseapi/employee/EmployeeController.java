package com.skillstrom.projectthree.warehouseapi.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping
    public Iterable<Employee> findAll() {
        return employeeService.findAll();
    }

    @PutMapping("/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable int id) {
        return employeeService.update(employee, id);
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Employee employee) {
        employeeService.delete(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        employeeService.deleteById(id);
    }


}
