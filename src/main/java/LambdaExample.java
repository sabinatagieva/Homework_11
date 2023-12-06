interface Calculator {
    int calculate(int x, int y);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Лямбда-выражения для разных математических операций
        Calculator addition = (x, y) -> x + y;
        Calculator subtraction = (x, y) -> x - y;
        Calculator multiplication = (x, y) -> x * y;
        Calculator division = (x, y) -> (y != 0) ? x / y : 0;

        // Пример использования
        System.out.println("Сложение: " + addition.calculate(5, 3));
        System.out.println("Вычитание: " + subtraction.calculate(5, 3));
        System.out.println("Умножение: " + multiplication.calculate(5, 3));
        System.out.println("Деление: " + division.calculate(5, 3));
    }
}
