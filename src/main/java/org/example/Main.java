package org.example;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner objection = new Scanner(System.in);
        System.out.println("Input: ");

        String input = objection.nextLine();
        try {
            String result = calc(input);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) {
        try {
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
                    return String.valueOf(a / b);
                }
                default -> throw new IllegalArgumentException("Incorrect operator: " + operator);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect number input.");
        } catch (Exception e) {
            throw new IllegalArgumentException("Error: " + e.getMessage());
        }
    }
}
