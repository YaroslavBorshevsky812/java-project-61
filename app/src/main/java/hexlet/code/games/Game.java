package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Game {

    public static void start() {
        Engine.showMenu();

        Scanner scanner = new Scanner(System.in);

        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1 -> Engine.checkUserName();
            case 2 -> Even.start(userChoice);
            case 3 -> Calc.start(userChoice);
            case 4 -> GCD.start(userChoice);
            case 5 -> Progression.start(userChoice);
            case 6 -> Prime.start(userChoice);
            default -> {
                return;
            }
        }
    }

}
