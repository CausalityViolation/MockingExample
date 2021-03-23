package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeManager {

    private final EmployeeRepository employeeRepository;
    private final BankService bankService;

    public EmployeeManager(EmployeeRepository employeeRepository, BankService bankService) {
        this.employeeRepository = employeeRepository;
        this.bankService = bankService;
    }

    public int payEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        int payments = 0;
        for (Employee employee : employees) {
            try {
                bankService.pay(employee.getId(), employee.getSalary());
                employee.setPaid(true);
                payments++;
            } catch (RuntimeException e) {
                employee.setPaid(false);
            }
        }
        return payments;
    }

}