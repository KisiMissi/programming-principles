import io.MessagesReader;
import io.MessagesWriter;

import java.util.Random;
import java.util.Scanner;

public class GuessingProcess {

    private static final int CLOSE_UPPER_BOUND = 5;
    private static final int NEAR_UPPER_BOUND = 2;

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 10;

    private static final String WRONG_ANSWER = "Читать не умеешь?";
    private static final String FAR_FROM_RIGHT_ANSWER = "Холодно";
    private static final String CLOSE_TO_RIGHT_ANSWER = "Тепло";
    private static final String NEAR_AN_ANSWER = "Жгётся!";

    private static final String WIN = "╰(▔∀▔)╯";
    private static final String GUESS_NUMBER = "угадай число от " + MIN_VALUE + " до " + MAX_VALUE;

    private static final MessagesWriter writer = new MessagesWriter();
    private static final MessagesReader reader = new MessagesReader();

    public static void start() {
        int targetNumber = setTargetNumber();
        int answer = reader.readNum();

        while(answer != targetNumber) {
            int howCloseToRightNum = Math.abs(answer - targetNumber);
            String help;

            if (answer < MIN_VALUE || answer > MAX_VALUE)
                help = WRONG_ANSWER;
            else if (howCloseToRightNum > CLOSE_UPPER_BOUND)
                help = FAR_FROM_RIGHT_ANSWER;
            else if (howCloseToRightNum > NEAR_UPPER_BOUND)
                help = CLOSE_TO_RIGHT_ANSWER;
            else
                help = NEAR_AN_ANSWER;

            writer.write(help);
            answer = reader.readNum();
        }
        System.out.println(WIN);
    }

    private static int setTargetNumber() {
        writer.write(GUESS_NUMBER);
        return new Random().nextInt(MIN_VALUE, MAX_VALUE + 1);
    }
}
