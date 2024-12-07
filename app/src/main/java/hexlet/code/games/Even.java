package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Even {

    private static final String GAME_TITLE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int GAME_ID = 2; // Идентификатор игры.

    public static void start(int userChoice) {

        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        Engine.loop(Even::generateExample);
    }

    public static HashMap<String, String> generateExample() {
        HashMap<String, String> resultMap = new HashMap<>();

        int number = Utils.generateRandomNumber(Utils.MAX_RANDOM_RANGE);
        boolean isEven = number % 2 == 0;

        resultMap.put(isEven ? "yes" : "no", String.valueOf(number));

        return resultMap;
    }

}
