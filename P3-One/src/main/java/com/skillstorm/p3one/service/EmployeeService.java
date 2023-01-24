package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Employee;

public interface EmployeeService {

    Iterable<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    Employee update(Employee employee, int id);


}
