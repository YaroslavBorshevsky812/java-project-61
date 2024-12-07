package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Prime {

    private static final String GAME_TITLE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int GAME_ID = 6; // Идентификатор игры.

    public static void start(int userChoice) {
        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        Engine.loop(Prime::generateExample);
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

    public static HashMap<String, String> generateExample() {
        HashMap<String, String> resultMap = new HashMap<>();

        int number = Utils.generateRandomNumber(Utils.MAX_RANDOM_RANGE);
        boolean isPrime = isPrime(number);

        resultMap.put(isPrime ? "yes" : "no", String.valueOf(number));

        return resultMap;
    }
}
