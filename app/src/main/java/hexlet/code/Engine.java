package hexlet.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Engine {

    public static String userName; // Поля не должны быть public

    public static final int ITERATION_RANGE = 3; // Число итераций в игре;

    public static void checkUserName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner userInput = new Scanner(System.in);

        userName = userInput.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void showMenu() {

        Map<Integer, String> menu = new LinkedHashMap<>();

        menu.put(1, "Greet");
        menu.put(2, "Even");
        menu.put(3, "Calc");
        menu.put(4, "GCD");
        menu.put(5, "Progression");
        menu.put(6, "Prime");
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

    public static boolean digitsLogic(HashMap<Integer, String> taskMap) {
        for (Integer key : taskMap.keySet()) {

            System.out.println("Question: " + taskMap.get(key));
            Scanner scanner = new Scanner(System.in);
            int userAnswer = scanner.nextInt();
            System.out.println("Your answer: " + userAnswer);

            boolean isCorrect = userAnswer == key;

            if (isCorrect) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + key + ".");
                System.out.println("Let's try again, " + Engine.userName + "!");

                return false;
            }
        }
        return true;
    }

    public static boolean yesNoLogic(Integer question, boolean predicate) {
        System.out.println("Question: " + question);

        Scanner scanner = new Scanner(System.in);

        String userAnswer = scanner.nextLine();

        System.out.println("Your answer: " + userAnswer);

        String correctAnswer = predicate ? "'yes'" : "'no'";

        boolean isCorrect = (userAnswer.equals("yes") && predicate) || (userAnswer.equals("no") && !predicate);

        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println(
                "'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + correctAnswer + ".");
            System.out.println("Let's try again, " + Engine.userName + "!");

            return false;
        }

        return true;
    }

}
