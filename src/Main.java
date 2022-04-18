import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calc calculator = new Calc();
        calculator.calc();
    }
}
class Calc {
    static int meaning1;
    static int meaning2;
    static char mathOperator;
    static int result;
    static boolean isRoman1;
    static boolean isRoman2;

    public void calc () {
        System.out.println("ВВедите вычисляемое выражение:");
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();

        char[] arrayChar = new char[10];
        for (int i = 0; i < expression.length(); i++) {
            arrayChar [i] = expression.charAt(i);
            if (arrayChar [i] == '+') {
                mathOperator = '+';
            }
            if (arrayChar [i] == '-') {
                mathOperator = '-';
            }
            if (arrayChar [i] == '*') {
                mathOperator = '*';
            }
            if (arrayChar [i] == '/') {
                mathOperator = '/';
            }
        }
        String[] newExpression = expression.split("[+-/*]");
        if (newExpression.length > 2) {
            throw new InputMismatchException("Введено неверное количество операторов");
        } else if (newExpression.length ==1) {
            throw new InputMismatchException("Введеные данные не являются выражением");
        }

        String element1 = newExpression[0];
        String element2 = newExpression[1];


        try {
            if (element1.equals("I")) {
                isRoman1 = true;
                meaning1 = 1;
            } else if (element1.equals("II")) {
                isRoman1 = true;
                meaning1 = 2;
            } else if (element1.equals("III")) {
                isRoman1 = true;
                meaning1 = 3;
            } else if (element1.equals("IV")) {
                isRoman1 = true;
                meaning1 = 4;
            } else if (element1.equals("V")) {
                isRoman1 = true;
                meaning1 = 5;
            } else if (element1.equals("VI")) {
                isRoman1 = true;
                meaning1 = 6;
            } else if (element1.equals("VII")) {
                isRoman1 = true;
                meaning1 = 7;
            } else if (element1.equals("VIII")) {
                isRoman1 = true;
                meaning1 = 8;
            } else if (element1.equals("IX")) {
                isRoman1 = true;
                meaning1 = 9;
            } else if (element1.equals("X")) {
                isRoman1 = true;
                meaning1 = 10;
            }
            else {
                meaning1 =  Integer.parseInt(element1);
            }
        } catch (Exception e) {
            throw new InputMismatchException("Введены неверные данные");
        }
        // meaning2 = romanToArabian(element2, isRoman2);
        try {
            if (element2.equals("I")) {
                isRoman2 = true;
                meaning2 = 1;
            } else if (element2.equals("II")) {
                isRoman2 = true;
                meaning2 = 2;
            } else if (element2.equals("III")) {
                isRoman2 = true;
                meaning2 = 3;
            } else if (element2.equals("IV")) {
                isRoman2 = true;
                meaning2 = 4;
            } else if (element2.equals("V")) {
                isRoman2 = true;
                meaning2 = 5;
            } else if (element2.equals("VI")) {
                isRoman2 = true;
                meaning2 = 6;
            } else if (element2.equals("VII")) {
                isRoman2 = true;
                meaning2 = 7;
            } else if (element2.equals("VIII")) {
                isRoman2 = true;
                meaning2 = 8;
            } else if (element2.equals("IX")) {
                isRoman2 = true;
                meaning2 = 9;
            } else if (element2.equals("X")) {
                isRoman2 = true;
                meaning2 = 10;
            }else {
                meaning2 =  Integer.parseInt(element2);
            }
        } catch (Exception e) {
            throw new InputMismatchException("Введены неверные данные");
        }

        if (isRoman1 & isRoman2) {
            result = calculation( meaning1, meaning2, mathOperator);
            String romanResult = listOfRomanNumerals(result);
            System.out.println("Результат:");
            System.out.println(romanResult);

        } else {
            meaning1 = Integer.parseInt(element1);
            meaning2 = Integer.parseInt(element2);
            result = calculation(meaning1, meaning2, mathOperator);
            System.out.println("Результат: ");
            System.out.println(result);
        }
    }

    static String listOfRomanNumerals(int number) {
        String[] romanNumber = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI",
                "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = romanNumber[number];
        return s;
    }

    static int calculation (int value1, int value2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '*':
                result = value1 * value2;
                break;
            case '/':
                try {
                    result = value1 / value2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Введено недопустимое значение");
                }
                break;
        }
        return result;
    }
}