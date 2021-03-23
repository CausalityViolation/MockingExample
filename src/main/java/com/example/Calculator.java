package com.example;

import java.util.Arrays;

public class Calculator {

    public int add(String text) {

        int sum;

        if (text.isEmpty()) {

            sum = 0;

        } else {

            if (text.startsWith("//")) {

                String[] newText;

                var textSubstring = text.substring(2, 3);
                var textWithoutDelimiter = text.substring(4);

                newText = textWithoutDelimiter.split(textSubstring);

                sum = Arrays.stream(newText).map(Integer::parseInt).mapToInt(each -> each).sum();

            } else {

                String[] newText = text.split("[\n,;/^*=]");

                sum = Arrays.stream(newText).map(Integer::parseInt).mapToInt(each -> each).sum();

            }
        }

        return sum;
    }


}
