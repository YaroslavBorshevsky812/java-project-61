package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class GCD {

    private static final String GAME_TITLE = "Find the greatest common divisor of given numbers.";
    public static final int GAME_ID = 4; // Идентификатор игры.

    public static void start(int userChoice) {
        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        int counter = 0;

        while (counter != Engine.ITERATION_RANGE) {
            HashMap<Integer, String> exampleMap = generateGCD();

            if (!Engine.digitsLogic(exampleMap)) {
                return;
            }

            counter++;
        }

        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }

    public static HashMap<Integer, String> generateGCD() {
        HashMap<Integer, String> resultMap = new HashMap<>();
        int[] numbers = Utils.generateRandomDifferentNumbers();
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
}
