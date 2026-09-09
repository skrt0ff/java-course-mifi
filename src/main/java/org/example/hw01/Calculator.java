package org.example.hw01;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        System.out.println("Привет! Это калькулятор");
        System.out.println("Доступные операции: +  -  *  /");
        System.out.println("с - сброс, s - выход");
        System.out.print("Введите первое число: ");

        result = scanner.nextDouble();

        while (true) {
            System.out.print("Введите операцию: ");
            char operation = scanner.next().charAt(0);

            if (operation == 's' || operation == 'S') {
                System.out.println("Работа калькулятора завершена");
                break;
            }

            if (operation == 'C' || operation == 'c') {
                result = 0;
                System.out.println("Результат сброшен");
                System.out.print("Введите первое число: ");
                result = scanner.nextDouble();
                continue;
            }

            if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                System.out.println("Неподдерживаемая операция! Используйте +, -, * или /");
                continue;
            }

            System.out.print("Введите второе число: ");
            double operand2 = scanner.nextDouble();

            switch (operation) {
                case '+':
                    result = add(result, operand2);
                    break;
                case '-':
                    result = subtract(result, operand2);
                    break;
                case '*':
                    result = multiply(result, operand2);
                    break;
                case '/':
                    if (operand2 == 0) {
                        System.out.println("Ошибка деления на ноль! Результат не изменён");
                        continue;
                    }
                    result = divide(result, operand2);
                    break;
                default:
                    System.out.println("Неподдерживаемая операция! Используйте +, -, * или /");
                    continue;
            }

            System.out.println("Результат: " + result);
        }

        scanner.close();
    }

    private static double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    private static double subtract(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    private static double multiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    private static double divide(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }
}

