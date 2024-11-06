package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Calc {

    private static final String GAME_TITLE = "What is the result of the expression?";

    public static void start(int userChoice) {
        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        int counter = 0;

        while (counter != Engine.ITERATION_RANGE) {
            HashMap<Integer, String> exampleMap = Utils.generateExample();

            if (!Engine.digitsLogic(exampleMap)) {
                return;
            }

            counter++;
        }

        System.out.println("Congratulations, " + Engine.userName + "!");
    }
}
