package com.calculator;

public class Check {
    public static void inputTypes() {
        int i = 0;
        while (i < Main.arInputNumbers.length) {

            if (is_empty(Main.arInputNumbers[i])) {
                try {
                    throw new Exception("строка не является математической операцией.");
                } catch (Exception ex) {
                    Main.exit(ex.getMessage());
                }
            }

            is_rome(Main.arInputNumbers[i]);

            if(Main.defLang.equals("arab")) {
                Main.arNumbers[i] = Integer.parseInt(Main.arInputNumbers[i]);
            } else {
                int j = 0;
                int romenumber = 0;
                while ( j < Main.arRomeNumbers.length) {
                    if(Main.arRomeNumbers[j].equals(Main.arInputNumbers[i])) {
                        romenumber = j;
                        break;
                    }
                    j++;
                }

                try {
                    if(romenumber == 0) {
                        throw new Exception("Не правильный ввод риских чисел.");
                    } else {
                        Main.arNumbers[i] = j;
                    }
                } catch (Exception ex) {
                    Main.exit(ex.getMessage());
                }

            }

            i++;
        }

        is_has_exception();
    }

    static void is_has_exception() {
        int i = 0;

        try {
            if(
                Main.defLang.equals("rome") &&
                Main.arNumbers[0] < Main.arNumbers[1] &&
                Main.operator.equals("-")
            ) {
                throw new Exception("В римской системе нет отрицательных чисел.");
            }

            while (i < Main.arNumbers.length) {

                if (Main.arNumbers[i] > 10) {
                    throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
                }

                i++;
            }

        } catch (Exception ex) {
            Main.exit(ex.getMessage());
        }

    }

    static void is_rome(String value) {
        int i = 0;
        String lang = "arab";

        while (i < value.length()) {
            var v = Character.toString( value.charAt(i));
            int j = 0;
            while (j < Main.arRomeNumbers.length) {
                if(Main.arRomeNumbers[j].equals(v)) {
                    lang = "rome";
                }
                j++;
            }

            i++;
        }

        if(Main.defLang == null) {
            Main.defLang = lang;
        } else {
            try {

                if(!(Main.defLang.equals(lang))) {
                    throw new Exception("используются одновременно разные системы счисления.");
                }

            } catch (Exception ex) {
                Main.exit(ex.getMessage());
            }

        }
    }



    static boolean is_empty(String value) {
        try {
            if(value == "") {
                throw new Exception("строка не является математической операцией.");
            } else {
                return false;
            }
        } catch (Exception ex) {
            Main.exit(ex.getMessage());
        }
        return true;
    }
}
