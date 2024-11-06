package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    private static final String GAME_TITLE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int GAME_ID = 6; // Идентификатор игры.

    public static void start(int userChoice) {
        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        int counter = 0;

        while (counter != Engine.ITERATION_RANGE) {

            int randomNumber = Utils.generateRandomNumber(Utils.MAX_RANDOM_RANGE);
            boolean isNatural = Utils.isPrime(randomNumber);

            if (!Engine.yesNoLogic(randomNumber, isNatural)) {
                return;
            }

            counter++;
        }
        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }
}
