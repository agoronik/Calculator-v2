package com.calculator;

public class Calculator {

    public static void init() {

        int result = calc_result();

        if(Main.defLang.equals("rome")) {
            System.out.println(ConverterRoman.init(result));
        } else {
            System.out.println(result);
        }

    }

    private static int calc_result() {
        int result = 0;

        if(Main.operator.equals("+")) {
            result = Main.arNumbers[0] + Main.arNumbers[1];
        }

        if(Main.operator.equals("-")) {
            result = Main.arNumbers[0] - Main.arNumbers[1];
        }

        if(Main.operator.equals("/")) {
            result = Main.arNumbers[0] / Main.arNumbers[1];
            var div = Main.arNumbers[0] % Main.arNumbers[1];
            if(div > 0) {
                result++;
            }
        }

        if(Main.operator.equals("*")) {
            result = Main.arNumbers[0] * Main.arNumbers[1];
        }

        return result;
    }



}
