package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    private static final String GAME_TITLE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start(int userChoice) {

        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        int counter = 0;

        while (counter != Engine.ITERATION_RANGE) {
            int randomNumber = Utils.generateRandomNumber(Utils.MAX_RANDOM_RANGE);
            boolean isEven = randomNumber % 2 == 0;

            if (!Engine.yesNoLogic(randomNumber, isEven)) {
                return;
            }

            counter++;

        }

        System.out.println("Congratulations, " + Engine.userName + "!");

    }

}
