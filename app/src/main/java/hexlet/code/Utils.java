package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();

    public static HashMap<Integer, String> generateExample() {
        int num1, num2, result = 0;
        String example;
        String operation = getOperation();

        HashMap<Integer, String> resultMap = new HashMap<>();

        if (operation.equals("-")) {
            num1 = RANDOM.nextInt(100) + 1;
            num2 = RANDOM.nextInt(num1) + 1;
        } else {
            num1 = RANDOM.nextInt(100) + 1;
            num2 = RANDOM.nextInt(100) + 1;
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

        example = num1 + " " + operation + " " + num2 + " = ?";

        resultMap.put(result, example);

        return resultMap;
    }

    private static String getOperation() {
        int operationIndex = RANDOM.nextInt(3);
        return switch (operationIndex) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> "+";
        };
    }

    public static int[] generateRandomDifferentNumbers() {
        int num1 = (int) (Math.random() * 100) + 1;

        int num2;
        do {
            num2 = (int) (Math.random() * 100) + 1;
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
        Random random = new Random();

        int start = random.nextInt(100) + 1;
        int end = random.nextInt(100) + start + 1;
        int length = random.nextInt(6) + 5;

        int step = (int) Math.round((double) (end - start) / (length - 1));

        List<Object> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            progression.add(start + i * step);
        }

        int randomIndex = random.nextInt(progression.size());
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
}
