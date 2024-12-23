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

            String operator = parts[1];

            int result = calculate(a, b, operator);
            System.out.println("Result: " + result);

        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return a / b;
            }
            default -> throw new IllegalArgumentException("Некорректный оператор: " + operator);
        }
    }
}