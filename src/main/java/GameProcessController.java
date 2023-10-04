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
            gameParticipation(answer);
        }
    }

    private String wantStartGame() {
        writer.write(START_THE_GAME);
        return reader.readAnswer();
    }

    private void gameParticipation(String answer) {
        if (answer.equals(YES))
            GuessingProcess.start();
        else
            continueGame(answer);
    }
    private void continueGame(String answer) {
        if (answer.equals(NO)) {
            writer.write(ANSWER_TO_NO);
            System.exit(0);
        } else if (!answer.equals(YES)) {
            writer.write(UNEXPECTED_ANSWER);
            System.exit(0);
        }
        writer.write(ANSWER_TO_YES);
    }
}
