package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calcTest = new Calculator();

    @Test
    void addTest() {

        var actual = 3;

        calcTest.add("1\n1,1");

        assertEquals(3, actual);

    }

    @Test
    void addEmptyTest() {

        var newString = "";

        calcTest.add(newString);

        assertEquals("",newString);

    }


}