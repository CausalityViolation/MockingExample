package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calcTest = new Calculator();


    @Test
    void addTwoTest() {

        assertEquals(2, calcTest.add("1,1"));

    }

    @Test
    void addMoreDelimitersTest() {

        assertEquals(2, calcTest.add("1\n1"));

    }


    @Test
    void addTest() {

        assertEquals(8, calcTest.add("1\n1;1,1/1^1*1=1"));

    }

    @Test
    void addEmptyTest() {

        assertEquals(0, calcTest.add(""));

    }

    @Test
    void addDifferentDelimiters() {

        assertEquals(4, calcTest.add("//;\n1;2;1"));

    }

    @Test
    void negativesTest() {

        assertThrows(RuntimeException.class, () -> calcTest.add("-1,-1"));

    }

    @Test
    void ignoreBIGNumbersTest() {

        assertEquals(1,calcTest.add("1001,1"));

    }

    @Test
    void anyLengthDelimiterTest() {

        assertEquals(3, calcTest.add("//[**]\n1**1**1"));
    }

    @Test
    void multipleDelimitersTest(){

        assertEquals(6,calcTest.add("//[*][%]\n1*2%3)"));

    }

    @Test
    void multipleDelimitersLongerThanOneChar(){

        assertEquals(3,calcTest.add("//[**][%%]\n1**1%%1)"));
    }



}