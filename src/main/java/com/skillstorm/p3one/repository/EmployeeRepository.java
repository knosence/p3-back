package com.skillstorm.p3one.repository;

import com.skillstorm.p3one.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}