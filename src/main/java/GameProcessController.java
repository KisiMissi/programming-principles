import io.MessagesReader;
import io.MessagesWriter;

public class GameProcessController {

    private static final String YES = "да";
    private static final String NO = "нет";
    private static final String GREETING = "Привет!";
    private static final String START_THE_GAME = "Будешь угадывать? (" + YES + "/" + NO + ")";

    private static final String ANSWER_TO_YES = "(⌒‿⌒)";
    private static final String ANSWER_TO_NO = "(¬_¬ )";
    private static final String UNEXPECTED_ANSWER = "(︶︹︺)\n непонятно. Давай, до свидания!";

    private static final MessagesWriter writer = new MessagesWriter();
    private static final MessagesReader reader = new MessagesReader();

    public void launch() {
        writer.write(GREETING);
        while (true) {
            String answer = wantStartGame();
            boolean startGame = gameParticipation(answer);

            if (startGame)
                GuessingProcess.start();
            else
                break;
        }
    }

    private String wantStartGame() {
        writer.write(START_THE_GAME);
        return reader.readAnswer();
    }

    private boolean gameParticipation(String answer) {
        if (answer.equals(YES)) {
            writer.write(ANSWER_TO_YES);
            return true;
        } else if (answer.equals(NO)) {
            writer.write(ANSWER_TO_NO);
            return false;
        } else {
            writer.write(UNEXPECTED_ANSWER);
            return false;
        }
    }
}
