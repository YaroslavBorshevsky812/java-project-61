package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static hexlet.code.Utils.MAX_PROGRESSION_RANGE;
import static hexlet.code.Utils.MAX_RANDOM_RANGE;
import static hexlet.code.Utils.MIN_PROGRESSION_RANGE;

public class Progression {

    private static final String GAME_TITLE = "What number is missing in the progression?";
    public static final int GAME_ID = 5; // Идентификатор игры.

    public static void start(int userChoice) {
        Engine.showChoice(userChoice);
        Engine.checkUserName();

        System.out.println(GAME_TITLE);

        Engine.loop(Progression::createProgression);

        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }

    public static HashMap<String, String> createProgression() {
        HashMap<String, String> resultMap = new HashMap<>();

        int start = Utils.generateRandomNumber(MAX_RANDOM_RANGE);
        int end = Utils.generateRandomNumber(MAX_RANDOM_RANGE);
        int length = Utils.generateRandomNumber(MAX_PROGRESSION_RANGE, MIN_PROGRESSION_RANGE);

        int step = (int) Math.round((double) (end - start) / (length - 1));

        List<Object> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            progression.add(start + i * step);
        }

        int randomIndex = Utils.generateRandomNumber(progression.size() - 1);
        int answer = (int) progression.get(randomIndex);
        progression.set(randomIndex, "..");
        String example = progression.toString()
                                    .replace("[", "")
                                    .replace("]", "")
                                    .replace(",", "");

        resultMap.put(String.valueOf(answer), example);

        return resultMap;
    }

}
