package com.example;


import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {


    @Test
    void NumberOfEmployeesPaidTest() {

        BankService testBank = new TestBankService();
        EmployeeRepository testRepo = new TestEmpRepo();
        EmployeeManager testEmployee = new EmployeeManager(testRepo, testBank);

        assertEquals(4, testEmployee.payEmployees());

    }

    @Test
    void NumberOfEmployeesPaidMockitoTest() {

        BankService mockBank = mock(BankService.class);
        EmployeeRepository mockRepo = mock(EmployeeRepository.class);

        when(mockRepo.findAll()).thenReturn(List.of(
                new Employee("first", 500),
                new Employee("second", 1000),
                new Employee("third", 1500),
                new Employee("fourth", 2000)));

        EmployeeManager testEmp = new EmployeeManager(mockRepo, mockBank);


        assertEquals(4, testEmp.payEmployees());

    }
}

