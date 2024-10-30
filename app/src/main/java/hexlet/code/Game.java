package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private final Map<Integer, String> menu;
	private String userName;

	public Game() {
		this.menu = new HashMap<>();
		menu.put(1, "Greet");
		menu.put(2, "Even");
		menu.put(0, "Exit");
	}

	public void start() {
		showMenu();

		Scanner scanner = new Scanner(System.in);

		switch (scanner.nextInt()) {
			case 1:
				checkUserName();
				break;
			case 2:
				even();
				break;
			default:
				return;
		}

	}

	private void showMenu() {
		System.out.println("Please enter the game number and press Enter.");
		for (Map.Entry<Integer, String> entry : menu.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

	private void checkUserName() {
		System.out.println("Welcome to the Brain Games!");
		System.out.println("May I have your name?");
		Scanner userInput = new Scanner(System.in);

		this.userName = userInput.nextLine();
		System.out.println("Hello, " + this.userName + "!");
	}

	private void even() {
		checkUserName();
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

			if (!isCorrect || (!userAnswer.equals("yes") && !userAnswer.equals("no")))  {
				System.out.println("'"+ userAnswer + "'" + " is wrong answer ;(. Correct answer was " + correctAnswer + ".");
				System.out.println("Let's try again, " + this.userName + "!");

				return;
			}

			counter++;
		}

		System.out.println("Congratulations, " + userName + "!");

	}
}
