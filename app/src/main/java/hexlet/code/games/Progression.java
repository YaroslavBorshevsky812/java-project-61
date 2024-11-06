package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Progression {

    private static final String GAME_TITLE = "What number is missing in the progression?";

    public static void start(int userChoice) {
        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        int counter = 0;

        while (counter != Engine.ITERATION_RANGE) {
            HashMap<Integer, String> exampleMap = Utils.createProgression();
            Engine.digitsLogic(exampleMap);

            counter++;
        }

        System.out.println("Congratulations, " + Engine.userName + "!");
    }
}
