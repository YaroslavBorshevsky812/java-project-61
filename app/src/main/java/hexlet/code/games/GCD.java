package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class GCD {

    private static final String GAME_TITLE = "Find the greatest common divisor of given numbers.";

    public static void start(int userChoice) {
        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        int counter = 0;

        while (counter != Engine.ITERATION_RANGE) {
            HashMap<Integer, String> exampleMap = Utils.generateGCD();
            Engine.digitsLogic(exampleMap);

            counter++;
        }

        System.out.println("Congratulations, " + Engine.userName + "!");
    }
}
