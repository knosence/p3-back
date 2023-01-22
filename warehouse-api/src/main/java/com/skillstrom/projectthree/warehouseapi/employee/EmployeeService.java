package com.skillstrom.projectthree.warehouseapi.employee;

public interface EmployeeService {

    Iterable<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee update(Employee employee, int id);

    void delete(Employee employee);

    void deleteById(int id);


    //Iterable<Employee> findEmployeesByWarehouseId(int id);
}