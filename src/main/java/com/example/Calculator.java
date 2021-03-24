package com.example;

import java.util.Arrays;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String text) {

        int sum;


        if (text.isEmpty()) {

            sum = 0;

        } else {

            if (text.startsWith("//")) {

                 sum = Pattern.compile("[^-?0-9]+")
                        .splitAsStream(text).filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .sum();


            } else {

                String[] newText = text.split("[\n,;/^*=]");

                sum = Arrays.stream(newText)
                        .map(Integer::parseInt)
                        .peek(throwException)
                        .filter(overOneThousand)
                        .mapToInt(each -> each)
                        .sum();

            }
        }

        return sum;
    }

    Consumer<Integer> throwException = x -> {
        if (x < 0) {
            throw new RuntimeException();
        }


    };

    Predicate<Integer> overOneThousand = x -> x < 1001;


}
