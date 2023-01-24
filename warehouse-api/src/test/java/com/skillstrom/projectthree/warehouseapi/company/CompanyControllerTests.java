package com.skillstrom.projectthree.warehouseapi.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstrom.projectthree.warehouseapi.location.Location;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompanyController.class)
class CompanyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getById_Successful() throws Exception {
        // set up a mock company
        Company company = new Company();
        company.setCompanyName("Test Company");
        company.setLocation(new Location());
        company.setCompanyId(1);

        Mockito.when(companyService.getById(1)).thenReturn(company);

        mockMvc.perform(MockMvcRequestBuilders.get("/company/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(company)));

        verify(companyService, times(1)).getById(1);

    }

    @Test
    void getAll_Successful() throws Exception {
        // set up a mock company
        Company company = new Company();
        company.setCompanyName("Test Company");
        company.setLocation(new Location());
        company.setCompanyId(1);

        Mockito.when(companyService.getAllCompanies()).thenReturn(Arrays.asList(company));

        mockMvc.perform(get("/company"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(new Company[]{company})));

        verify(companyService, times(1)).getAllCompanies();
    }

    @Test
    void create_Successful() throws Exception {
        // set up a mock company
        Company company = new Company();
        company.setCompanyName("Test Company");
        company.setLocation(new Location());
        company.setCompanyId(1);

        Mockito.when(companyService.create(company)).thenReturn(company);

        mockMvc.perform(MockMvcRequestBuilders.post("/company")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(company)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(company)));

        verify(companyService, times(1)).create(company);
    }

    @Test
    void update_Successful() throws Exception {
        // set up a mock company
        Company company = new Company();
        company.setCompanyName("Test Company");
        company.setLocation(new Location());
        company.setCompanyId(1);

        Mockito.when(companyService.update(company, 1)).thenReturn(company);

        mockMvc.perform(MockMvcRequestBuilders.put("/company/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(company)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(company)));

        verify(companyService, times(1)).update(company, 1);

    }

    @Test
    void deleteById_Successful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/company/1"))
                .andExpect(status().isOk());

        verify(companyService, times(1)).deleteById(1);
    }


}
