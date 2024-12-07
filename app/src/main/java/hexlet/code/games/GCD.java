package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class GCD {

    private static final String GAME_TITLE = "Find the greatest common divisor of given numbers.";
    public static final int GAME_ID = 4; // Идентификатор игры.

    public static void start() {
        System.out.println(GAME_TITLE);

        Engine.loop(GCD::generateGCD);
    }

    public static HashMap<String, String> generateGCD() {
        HashMap<String, String> resultMap = new HashMap<>();
        int[] numbers = Utils.generateRandomDifferentNumbers();
        int gcd = findGreatestCommonDivisor(numbers[0], numbers[1]);
        String example = "";

        example = numbers[0] + " " + numbers[1];

        resultMap.put(String.valueOf(gcd), example);

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
}
