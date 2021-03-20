package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {


    @Test
    void addTest() {

        int actual = EmployeeManager.add("1", "1");

        assertEquals(2, actual);

    }

    @Test
    void addEmptyTest() {

        int actual = EmployeeManager.add("", "");

        assertEquals(0, actual);

    }

    @Test
    void oneEmptyTest() {

        int actual = EmployeeManager.add("", "1");

        assertEquals(1, actual);

    }

    @Test
    void num2EmptyTest() {

        int actual = EmployeeManager.add("1", "");

        assertEquals(1, actual);
    }
}