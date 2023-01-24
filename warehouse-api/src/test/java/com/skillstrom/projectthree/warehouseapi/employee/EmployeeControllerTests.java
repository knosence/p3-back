package com.skillstrom.projectthree.warehouseapi.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstrom.projectthree.warehouseapi.warehouse.Warehouse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findById_Successful() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setFirstName("Test");
        employee.setLastName("Employee");
        employee.setWarehouse(new Warehouse());
        employee.setEmployeePassword("password");
        employee.setUserRole("user");
        employee.setEmployeeEmail("abc@123.com");

        Mockito.when(employeeService.findById(1)).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(employee)));

        verify(employeeService, times(1)).findById(1);

    }

    @Test
    void findAll_Successful() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setFirstName("Test");
        employee.setLastName("Employee");
        employee.setWarehouse(new Warehouse());
        employee.setEmployeePassword("password");
        employee.setUserRole("EMPLOYEE");
        employee.setEmployeeEmail("abc@123.com");

        Mockito.when(employeeService.findAll()).thenReturn(Collections.singletonList(employee));

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(employee))));

        verify(employeeService, times(1)).findAll();
    }

    @Test
    void create_Successful() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("Employee");
        employee.setEmployeePassword("password");
        employee.setUserRole("EMPLOYEE");
        employee.setEmployeeEmail("abc@emil.com");

        Mockito.when(employeeService.create(employee)).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(employee)));

        verify(employeeService, times(1)).create(employee);

    }

    @Test
    void update_Successful() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setFirstName("Test");
        employee.setLastName("Employee");
        //employee.setWarehouse(new Warehouse());
        employee.setEmployeePassword("password");
        employee.setUserRole("EMPLOYEE");
        employee.setEmployeeEmail("abc@gmail.com");

        Mockito.when(employeeService.update(employee, 1)).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.put("/employee/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(employee)));

        verify(employeeService, times(1)).update(employee, 1);
    }

    @Test
    void deleteById_Successful() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setFirstName("Test");
        employee.setLastName("Employee");
        employee.setWarehouse(new Warehouse());
        employee.setEmployeePassword("password");
        employee.setUserRole("EMPLOYEE");
        employee.setEmployeeEmail("");

        Mockito.when(employeeService.findById(1)).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.delete("/employee/1"))
                .andExpect(status().isNoContent());

        verify(employeeService, times(1)).deleteById(1);
    }


    @Test
    void delete_successful() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setFirstName("Test");
        employee.setLastName("Employee");
        //employee.setWarehouse(new Warehouse());
        employee.setEmployeePassword("password");
        employee.setUserRole("EMPLOYEE");
        employee.setEmployeeEmail("");

        Mockito.when(employeeService.findById(1)).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.delete("/employee")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        verify(employeeService, times(1)).delete(employee);
    }



}
