package com.example;

import java.util.List;

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

    public static int add(String n1, String n2) {


        if (n1.isEmpty() && n2.isEmpty()) {
            return 0;

        } else if (n1.isEmpty()) {

            return Integer.parseInt(n2);
        } else if (n2.isEmpty()) {

            return Integer.parseInt(n1);
        }

        return Integer.parseInt(n1) + Integer.parseInt(n2);
    }
}
