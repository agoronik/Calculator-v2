package com.calculator;

public class Parsing {
    public static void inputStr(String str) {
        boolean step_operator = false;
//parseInt

        for(int i=0; i<str.length(); i++) {
            var value = Character.toString( str.charAt(i));


            try {

                if(value.equals(".")) {
                    throw new Exception("Не верный формат числе. Только целые числа 1...10 .");
                }

                if(is_operator(value)) {
                    if(Main.operator != null) {
                        throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    } else {
                        Main.operator = value;
                        step_operator = true;
                        continue;
                    }
                }

            } catch (Exception ex) {
                Main.exit(ex.getMessage());
            }

            if(step_operator == false) {
                Main.arInputNumbers[0] += value;
            } else {
                Main.arInputNumbers[1] += value;
            }

        }

        try {
            if(Main.operator == null) {
                throw new Exception("строка не является математической операцией");
            }
        } catch (Exception ex) {
            Main.exit(ex.getMessage());
        }


    }

    public static boolean is_operator(String value) {
        boolean result = false;

        switch (value) {
            case "+":
                result = true;
                break;
            case "-":
                result = true;
                break;
            case "*":
                result = true;
                break;
            case "/":
                result = true;
                break;
        }

        return result;

    }
}
