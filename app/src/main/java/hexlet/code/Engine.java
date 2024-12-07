package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Hello;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Engine {

    private static String userName; // Поля не должны быть public
    public static final int ITERATION_RANGE = 3; // Число итераций в игре;

    public static String getUserName() {
        return userName;
    }

    public static void checkUserName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner userInput = new Scanner(System.in);

        userName = userInput.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void showMenu() {

        Map<Integer, String> menu = new LinkedHashMap<>();

        menu.put(Hello.GAME_ID, "Greet");
        menu.put(Even.GAME_ID, "Even");
        menu.put(Calc.GAME_ID, "Calc");
        menu.put(GCD.GAME_ID, "GCD");
        menu.put(Progression.GAME_ID, "Progression");
        menu.put(Prime.GAME_ID, "Prime");
        menu.put(0, "Exit");

        System.out.println("Please enter the game number and press Enter.");
        for (Map.Entry<Integer, String> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void showChoice(int userChoice) {
        System.out.println("Your choice: " + userChoice);
        System.out.println();
    }

    public static boolean logic(String question, String rightAnswer) {
        System.out.println("Question: " + question);

        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
        System.out.println("Your answer: " + userAnswer);

        boolean isCorrect = userAnswer.equals(rightAnswer);

        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println(
                "'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + rightAnswer + ".");
            System.out.println("Let's try again, " + Engine.userName + "!");

            return true;
        }

        System.out.println("Congratulations, " + Engine.getUserName() + "!");

        return false;
    }

    public static void loop(AnswerExampleInterface mapMethod) {
        int counter = 0;

        while (counter != Engine.ITERATION_RANGE) {
            HashMap<String, String> answerExampleMap = mapMethod.getAnswerExampleMap();
            String answer = answerExampleMap.keySet().iterator().next();
            String example = answerExampleMap.get(answer);

            if (Engine.logic(example, answer)) {
                return;
            }

            counter++;
        }
    }

    public interface AnswerExampleInterface {
        HashMap<String, String> getAnswerExampleMap();
    }
}
