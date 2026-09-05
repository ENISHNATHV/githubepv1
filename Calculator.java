import java.util.Scanner;

public class Calculator {
    public static double calculate(double firstNumber, double secondNumber, char operator) {
        switch (operator) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Java Calculator");
        System.out.println("Enter q at any time to quit.");

        while (true) {
            System.out.print("First number: ");
            if (!scanner.hasNextDouble()) {
                if (scanner.next().equalsIgnoreCase("q")) {
                    break;
                }
                System.out.println("Please enter a valid number.");
                continue;
            }
            double firstNumber = scanner.nextDouble();

            System.out.print("Operator (+, -, *, /): ");
            String operatorInput = scanner.next();
            if (operatorInput.equalsIgnoreCase("q")) {
                break;
            }
            char operator = operatorInput.charAt(0);

            System.out.print("Second number: ");
            if (!scanner.hasNextDouble()) {
                if (scanner.next().equalsIgnoreCase("q")) {
                    break;
                }
                System.out.println("Please enter a valid number.");
                continue;
            }
            double secondNumber = scanner.nextDouble();

            try {
                double result = calculate(firstNumber, secondNumber, operator);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException | ArithmeticException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        scanner.close();
        System.out.println("Calculator closed.");
    }
}
