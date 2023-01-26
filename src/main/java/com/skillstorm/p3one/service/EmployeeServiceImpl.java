package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Employee;
import com.skillstorm.p3one.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee employee, int id) {
        //Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setId(id);
        //employee1.setFirstName(employee.getFirstName());
        //employee1.setLastName(employee.getLastName());
        //employee1.setEmployeeEmail(employee.getEmployeeEmail());
        //employee1.setEmployeePassword(employee.getEmployeePassword());
        //employee1.setUserRole(employee.getUserRole());
        return employeeRepository.save(employee);

    }


}
