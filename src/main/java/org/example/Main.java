package org.example;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner objection = new Scanner(System.in);
        System.out.println("Input: ");

        try {
            String input = objection.nextLine();
            String[] parts = input.split(" ");

            if(parts.length != 3)
            {
                throw new IllegalArgumentException("Incorrect format. Use format: a <operator> b.");
            }

            int a = parseInt(parts[0]);
            int b = parseInt(parts[2]);

            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Numbers should be between 1 and 10");
            }

            String operator = parts[1];

            String result = Calculate(a, b, operator);
            System.out.println("Result: " + result);

        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String Calculate(int a, int b, String operator) {
        switch (operator) {
            case "+" -> {
                return String.valueOf(a + b);
            }
            case "-" -> {
                return String.valueOf(a - b);
            }
            case "*" -> {
                return String.valueOf(a * b);
            }
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль не допускается.");
                }
                return String.valueOf(a / b);
            }
            default -> throw new IllegalArgumentException("Некорректный оператор: " + operator);
        }
    }
}