package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Hello;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    public static void start() {
        Engine.showMenu();

        Scanner scanner = new Scanner(System.in);

        int userChoice = scanner.nextInt();

        Engine.showChoice(userChoice);
        Engine.checkUserName();

        switch (userChoice) {
            case Hello.GAME_ID -> Hello.start();
            case Even.GAME_ID -> Even.start();
            case Calc.GAME_ID -> Calc.start();
            case GCD.GAME_ID -> GCD.start();
            case Progression.GAME_ID -> Progression.start();
            case Prime.GAME_ID -> Prime.start();
            default -> {
                throw new RuntimeException("Unknown user choice " + userChoice);
            }
        }
    }

    public static void main(String[] args) {
        App.start();
    }
}
