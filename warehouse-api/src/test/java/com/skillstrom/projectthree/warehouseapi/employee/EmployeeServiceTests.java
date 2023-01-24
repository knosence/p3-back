package com.skillstrom.projectthree.warehouseapi.employee;

import com.skillstrom.projectthree.warehouseapi.warehouse.Warehouse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTests {

    private static Employee employee;

    @BeforeAll
    static void setup() {
        employee = new Employee();
        employee.setEmployeeId(1);
        employee.setFirstName("Test");
        employee.setLastName("Employee");
        employee.setWarehouse(new Warehouse());
        employee.setEmployeePassword("password");
        employee.setUserRole("EMPLOYEE");
        employee.setEmployeeEmail("abc@mail.com");
    }

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void createEmployee_Successful() {
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Employee result = employeeService.create(employee);
        assertEquals(employee, result);
    }

    @Test
    void update_Successful() {
        when(employeeRepository.existsById(anyInt())).thenReturn(true);
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee result = employeeService.update(employee, 1);

        assertEquals(employee, result);

        verify(employeeRepository, times(1)).existsById(anyInt());
        verify(employeeRepository, times(1)).save(any());

    }

    @Test
    void delete_Successful() {
        employeeService.delete(employee);
        Mockito.verify(employeeRepository).delete(employee);
    }

    @Test
    void deleteById_Successful() {
        employeeService.deleteById(1);
        verify(employeeRepository).deleteById(1);
    }


}
