package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.MathGenerator;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Engine engine;

    public Game() {
        this.engine = new Engine();
    }

    public void start() {
        this.engine.showMenu();

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1 -> this.engine.checkUserName();
            case 2 -> even(userChoice);
            case 3 -> calc(userChoice);
            case 4 -> gcd(userChoice);
            default -> {
                return;
            }
        }

    }

    private void even(int userChoice) {
        this.engine.checkUserName();
        // Счетчик чтобы отслеживать итерации попыток.
        int counter = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (counter != 3) {

            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;
            boolean isEven = randomNumber % 2 == 0;

            System.out.println("Question: " + randomNumber);

            Scanner scanner = new Scanner(System.in);

            String userAnswer = scanner.nextLine();

            System.out.println("Your answer: " + userAnswer);

            String correctAnswer = isEven ? "'yes'" : "'no'";

            boolean isCorrect = (userAnswer.equals("yes") && isEven) || (userAnswer.equals("no") && !isEven);

            if (isCorrect) {
                System.out.println("Correct!");
            }

            if (!isCorrect || (!userAnswer.equals("yes") && !userAnswer.equals("no"))) {
                System.out.println(
                    "'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + correctAnswer + ".");
                System.out.println("Let's try again, " + this.engine.userName + "!");

                return;
            }

            counter++;
        }

        System.out.println("Congratulations, " + this.engine.userName + "!");

    }

    private void calc(int userChoice) {
        this.engine.checkUserName();
        // Счетчик чтобы отслеживать итерации попыток.
        int counter = 0;

        System.out.println("What is the result of the expression?");

        while (counter != 3) {

            HashMap<Integer, String> exampleMap = MathGenerator.generateExample();

            for (Integer key : exampleMap.keySet()) {

                System.out.println("Question: " + exampleMap.get(key));
                Scanner scanner = new Scanner(System.in);
                int userAnswer = scanner.nextInt();
                System.out.println("Your answer: " + userAnswer);

                boolean isCorrect = userAnswer == key;

                if (isCorrect) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + key + ".");
                    System.out.println("Let's try again, " + this.engine.userName + "!");

                    return;
                }
            }

            counter++;

        }

        System.out.println("Congratulations, " + this.engine.userName + "!");
    }

    private void gcd(int userChoice) {
        this.engine.checkUserName();

        // Счетчик чтобы отслеживать итерации попыток.
        int counter = 0;

        System.out.println("Find the greatest common divisor of given numbers.");

        while (counter != 3) {

            HashMap<Integer, String> exampleMap = MathGenerator.generateGCD();

            for (Integer key : exampleMap.keySet()) {

                System.out.println("Question: " + exampleMap.get(key));
                Scanner scanner = new Scanner(System.in);
                int userAnswer = scanner.nextInt();
                System.out.println("Your answer: " + userAnswer);

                boolean isCorrect = userAnswer == key;

                if (isCorrect) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + key + ".");
                    System.out.println("Let's try again, " + this.engine.userName + "!");

                    return;
                }
            }

            counter++;
        }
    }

}
