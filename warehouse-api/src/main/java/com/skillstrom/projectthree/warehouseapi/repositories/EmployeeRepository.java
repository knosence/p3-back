package com.skillstrom.projectthree.warehouseapi.repositories;

import com.skillstrom.projectthree.warehouseapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



    Iterable<Employee> findEmployeesByWarehouseId(int id);
}
