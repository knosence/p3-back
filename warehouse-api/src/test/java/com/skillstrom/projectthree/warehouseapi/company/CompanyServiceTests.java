package com.skillstrom.projectthree.warehouseapi.company;

import com.skillstrom.projectthree.warehouseapi.location.Location;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTests {

    private static Company company;

    @BeforeAll
    static void setup() {
        company = new Company();
        company.setCompanyName("Test Company");
        company.setLocation(new Location());
        company.setCompanyId(1);
    }

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Test
    void getById_Successful() {
        Mockito.when(companyRepository.findById(1)).thenReturn(java.util.Optional.of(company));
        Company result = companyService.getById(1);
        System.out.println(company);
        System.out.println(result);

        assertEquals(company, result);

    }

    @Test
    void getAll_Successful() {
        Mockito.when(companyService.getAllCompanies()).thenReturn(Collections.singletonList(company));
        assertEquals(Collections.singletonList(company), companyService.getAllCompanies());
    }

    @Test
    void createCompany_Successful() {
        Mockito.when(companyRepository.save(company)).thenReturn(company);
        Company result = companyService.create(company);
        assertEquals(company, result);
    }

    @Test
    void updateCompany_Successful() {
        Mockito.when(companyRepository.existsById(1)).thenReturn(true);
        Mockito.when(companyRepository.save(company)).thenReturn(company);
        Company result = companyService.update(company, 1);

        assertEquals(company, result);

        verify(companyRepository, times(1)).existsById(anyInt());
        verify(companyRepository, times(1)).save(any());
    }

    @Test
    void deleteCompany_Successful() {
        companyService.delete(company);
        verify(companyRepository).delete(company);

    }

    @Test
    void deleteById_Successful() {
        companyService.deleteById(1);
        verify(companyRepository).deleteById(1);
    }





}
