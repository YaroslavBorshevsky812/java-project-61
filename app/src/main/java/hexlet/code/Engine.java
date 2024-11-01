package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Engine {

    private final Map<Integer, String> menu;
    public String userName; // Поля не должны быть public

    public Engine() {
        this.menu = new HashMap<>();
        menu.put(1, "Greet");
        menu.put(2, "Even");
        menu.put(3, "Calc");
        menu.put(0, "Exit");
    }

    public void checkUserName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner userInput = new Scanner(System.in);

        this.userName = userInput.nextLine();
        System.out.println("Hello, " + this.userName + "!");
    }

    public void showMenu() {
        System.out.println("Please enter the game number and press Enter.");
        for (Map.Entry<Integer, String> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
