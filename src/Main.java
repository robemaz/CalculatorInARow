import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение ");
        Scanner scanner = new Scanner(System.in);
        String vyraz = scanner.nextLine();

        vyraz = vyraz.replaceAll("sqrt", "#");

        char[] operators = new char[vyraz.length()];
        int operatorCount = 0;

        for (int i = 0; i < vyraz.length(); i++) {
            char c = vyraz.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '#') {
                operators[operatorCount] = c;
                operatorCount++;
            }
        }

        if (operatorCount == 0) {
            System.out.println("Оператор не найден.");
        } else {
            String[] numbers = vyraz.split("[+\\-*/%#]|\\(|\\)]");
            double result = Double.parseDouble(numbers[0]);

            for (int i = 0; i < operatorCount; i++) {
                double nextNumber = Double.parseDouble(numbers[i + 1]);
                char operator = operators[i];

                if (operator == '+') {
                    result += nextNumber;
                } else if (operator == '-') {
                    result -= nextNumber;
                } else if (operator == '*') {
                    result *= nextNumber;
                } else if (operator == '/') {
                    if (nextNumber != 0) {
                        if (result >= nextNumber) {
                            result /= nextNumber;
                        } else {
                            System.out.println("Делить на большее значение нельзя.");
                        }
                    } else {
                        System.out.println("Делить на ноль нельзя.");
                    }
                } else if (operator == '%') {
                    if (nextNumber != 0) {
                        if (result >= nextNumber) {
                            result %= nextNumber;
                        } else {
                            System.out.println("Найти остаток из деления на большее значение нельзя.");
                        }
                    } else {
                        System.out.println("Найти остаток деления на ноль нельзя.");
                    }
                } else if (operator == '#') {
                    if (result >= 0) {
                        result = Math.sqrt(result);
                    } else {
                        System.out.println("Извлечение корня из отрицательного числа невозможно.");
                        return;
                    }
                }
            }
            System.out.println("Результат вычислений: " + result);
        }
        scanner.close();
    }
}