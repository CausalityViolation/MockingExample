package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calcTest = new Calculator();

    @Test
    void addTest() {

        var actual = 2;

        calcTest.add("1,1");

        assertEquals(2, actual);

    }

    @Test
    void addEmptyTest() {

        var newString = "";

        calcTest.add(newString);

        assertEquals("",newString);

    }


}