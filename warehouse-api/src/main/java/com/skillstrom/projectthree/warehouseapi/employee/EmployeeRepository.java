package com.skillstrom.projectthree.warehouseapi.employee;

import com.skillstrom.projectthree.warehouseapi.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
