package com.calculator;

import java.util.Scanner;

public class Main {

    static String defLang = null;
    static String [] arArabNumbers = {"0","1","2","3","4","5","6","7","8","9","10"};
    static String [] arRomeNumbers = {"", "I","II","III","IV","V","VI","VII","VIII","IX","X"};
    static String operator = null;
    static String[] arInputNumbers = {"",""};
    static int[] arNumbers = {0,0};

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String str = in.next();

        Parsing.inputStr(str);
        Check.inputTypes();

        Calculator.init();

    }

    static void exit(String erMessage) {
        System.out.println("throws Exception //т.к. " + erMessage);
        System.exit(1);
    }
    
}
