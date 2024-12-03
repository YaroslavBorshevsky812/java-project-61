package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

import static hexlet.code.Utils.MAX_RANDOM_RANGE;
import static hexlet.code.Utils.OPERATIONS_NUMBER;

public class Calc {

    private static final String GAME_TITLE = "What is the result of the expression?";
    public static final int GAME_ID = 3; // Идентификатор игры.

    public static final int SUMMATION_CASE = 1; // Сценарий операции суммы

    public static final int MULTIPLICATION_CASE = 2; // Сценарий операции умножения

    public static final int SUBTRACTION_CASE = 3; // Сценарий операции вычитания

    public static void start(int userChoice) {
        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        int counter = 0;

        while (counter != Engine.ITERATION_RANGE) {
            HashMap<Integer, String> exampleMap = generateExample();

            if (!Engine.digitsLogic(exampleMap)) {
                return;
            }

            counter++;
        }

        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }

    public static HashMap<Integer, String> generateExample() {
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        String example;
        String operation = getOperation();

        HashMap<Integer, String> resultMap = new HashMap<>();

        if (operation.equals("-")) {
            num1 = Utils.generateRandomNumber(MAX_RANDOM_RANGE);
            num2 = Utils.generateRandomNumber(num1);
        } else {
            num1 = Utils.generateRandomNumber(MAX_RANDOM_RANGE);
            num2 = Utils.generateRandomNumber(MAX_RANDOM_RANGE);
        }

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                throw new Error("Unknown operation " + operation);
        }

        example = (num1) + " " + operation + " " + (num2);

        resultMap.put(result, example);

        return resultMap;
    }

    private static String getOperation() {
        int operationIndex = Utils.generateRandomNumber(OPERATIONS_NUMBER);

        return switch (operationIndex) {
            case SUMMATION_CASE -> "-";
            case MULTIPLICATION_CASE -> "*";
            case SUBTRACTION_CASE -> "+";
            default -> throw new Error("Unknown user operationIndex " + operationIndex);
        };
    }
}
