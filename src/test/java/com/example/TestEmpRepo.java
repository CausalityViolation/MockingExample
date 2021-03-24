package com.example;

import java.util.ArrayList;
import java.util.List;

public class TestEmpRepo implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {

        ArrayList<Employee> dummies = new ArrayList<>();

        dummies.add(new Employee("first",500));
        dummies.add(new Employee("second", 1000));
        dummies.add(new Employee("third", 1500));
        dummies.add(new Employee("fourth",2000));

        return dummies;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
