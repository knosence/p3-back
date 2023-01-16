package com.skillstrom.projectthree.warehouseapi.services;

import com.skillstrom.projectthree.warehouseapi.models.Employee;
import com.skillstrom.projectthree.warehouseapi.repositories.EmployeeRepository;
import com.skillstrom.projectthree.warehouseapi.services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        if (!employeeRepository.existsById(employee.getEmployeeId())) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public Employee update(Employee employee, int id) {
        if (employeeRepository.existsById(id)) {
            employee.setEmployeeId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteById(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }

    }

    @Override
    public Iterable<Employee> findEmployeesByWarehouseId(int id) {
        return employeeRepository.findEmployeesByWarehouseId(id);
    }
}
