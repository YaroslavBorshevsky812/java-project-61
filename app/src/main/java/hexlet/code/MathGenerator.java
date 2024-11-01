package hexlet.code;

import java.util.HashMap;
import java.util.Random;

public class MathGenerator {

    private static final Random RANDOM = new Random();

    public static HashMap<Integer, String> generateExample() {
        int num1, num2, result = 0;
        String example;
        String operation = getOperation();

        HashMap<Integer, String> resultMap = new HashMap<>();

        if (operation.equals("-")) {
            num1 = RANDOM.nextInt(100) + 1;
            num2 = RANDOM.nextInt(num1) + 1;
        } else {
            num1 = RANDOM.nextInt(100) + 1;
            num2 = RANDOM.nextInt(100) + 1;
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
                break;
        }

        example = num1 + " " + operation + " " + num2 + " = ?";

        resultMap.put(result, example);

        return resultMap;
    }

    private static String getOperation() {
        int operationIndex = RANDOM.nextInt(3);
        return switch (operationIndex) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> "+";
        };
    }
}
