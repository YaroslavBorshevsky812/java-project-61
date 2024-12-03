package hexlet.code;

import java.util.Random;

public class Utils {

    public static final int MIN_RANDOM_RANGE = 1; // Минимальная граница диапазона рандомных чисел
    public static final int MAX_RANDOM_RANGE = 100; // Максимальная граница диапазона рандомных чисел
    public static final int MIN_PROGRESSION_RANGE = 5; // Минимальная граница диапазона рандомных чисел прогрессии
    public static final int MAX_PROGRESSION_RANGE = 15; // Максимальная граница диапазона рандомных чисел прогрессии
    public static final int OPERATIONS_NUMBER = 3; // Число операций для калькулятора.

    public static int[] generateRandomDifferentNumbers() {
        int num1 = generateRandomNumber(MAX_RANDOM_RANGE);

        int num2;
        do {
            num2 = generateRandomNumber(MAX_RANDOM_RANGE);
        }
        while (num2 == num1);

        return new int[] {num1, num2};
    }

    public static int generateRandomNumber(int maxRandomRange, int minRandomRange) {
        Random random = new Random();

        return random.nextInt(maxRandomRange) + minRandomRange;
    }

    public static int generateRandomNumber(int maxRandomRange) {
        Random random = new Random();

        return random.nextInt(maxRandomRange) + MIN_RANDOM_RANGE;
    }
}
