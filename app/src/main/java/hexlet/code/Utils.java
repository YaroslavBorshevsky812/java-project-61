package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Utils {

    public static final int MIN_RANDOM_RANGE = 1; // Минимальная граница диапазона рандомных чисел
    public static final int MAX_RANDOM_RANGE = 100; // Максимальная граница диапазона рандомных чисел
    public static final int MIN_PROGRESSION_RANGE = 5; // Минимальная граница диапазона рандомных чисел прогрессии
    public static final int MAX_PROGRESSION_RANGE = 15; // Максимальная граница диапазона рандомных чисел прогрессии

    public static HashMap<Integer, String> generateExample() {
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        String example;
        String operation = getOperation();

        HashMap<Integer, String> resultMap = new HashMap<>();

        if (operation.equals("-")) {
            num1 = generateRandomNumber(MAX_RANDOM_RANGE);
            num2 = generateRandomNumber(num1);
        } else {
            num1 = generateRandomNumber(MAX_RANDOM_RANGE);
            num2 = generateRandomNumber(MAX_RANDOM_RANGE);
        }

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                break;
        }

        example = (num1) + " " + operation + " " + (num2);

        resultMap.put(result, example);

        return resultMap;
    }

    private static String getOperation() {
        int operationIndex = generateRandomNumber(3);

        return switch (operationIndex) {
            case 1 -> "-";
            case 2 -> "*";
            default -> "+";
        };
    }

    public static int[] generateRandomDifferentNumbers() {
        int num1 = generateRandomNumber(MAX_RANDOM_RANGE);

        int num2;
        do {
            num2 = generateRandomNumber(MAX_RANDOM_RANGE);
        }
        while (num2 == num1);

        return new int[] {num1, num2};
    }

    public static HashMap<Integer, String> generateGCD() {
        HashMap<Integer, String> resultMap = new HashMap<>();
        int[] numbers = generateRandomDifferentNumbers();
        int gcd = findGreatestCommonDivisor(numbers[0], numbers[1]);
        String example = "";

        example = numbers[0] + " " + numbers[1];

        resultMap.put(gcd, example);

        return resultMap;
    }

    public static int findGreatestCommonDivisor(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static HashMap<Integer, String> createProgression() {
        HashMap<Integer, String> resultMap = new HashMap<>();

        int start = generateRandomNumber(MAX_RANDOM_RANGE);
        int end = generateRandomNumber(MAX_RANDOM_RANGE);
        int length = generateRandomNumber(MAX_PROGRESSION_RANGE, MIN_PROGRESSION_RANGE);

        int step = (int) Math.round((double) (end - start) / (length - 1));

        List<Object> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            progression.add(start + i * step);
        }

        int randomIndex = generateRandomNumber(progression.size());
        int answer = (int) progression.get(randomIndex);
        progression.set(randomIndex, "..");
        String example = progression.toString().replace("[", "").replace("]", "");

        resultMap.put(answer, example);

        return resultMap;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
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
