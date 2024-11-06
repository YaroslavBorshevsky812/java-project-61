package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Game {

    public static void start() {
        Engine.showMenu();

        Scanner scanner = new Scanner(System.in);

        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case Hello.GAME_ID -> Hello.start();
            case Even.GAME_ID -> Even.start(userChoice);
            case Calc.GAME_ID -> Calc.start(userChoice);
            case GCD.GAME_ID -> GCD.start(userChoice);
            case Progression.GAME_ID -> Progression.start(userChoice);
            case Prime.GAME_ID -> Prime.start(userChoice);
            default -> {
                return;
            }
        }
    }

}
