package com.example;

import java.util.Arrays;

public class Calculator {

    public int add(String text) {

        int sum;

        if (text.isEmpty()) {

            sum = 0;

        } else {

            String[] newText = text.split("[\n,;/^*=]");

            sum = Arrays.stream(newText).map(Integer::parseInt).mapToInt(each -> each).sum();

        }

        return sum;
    }


}
