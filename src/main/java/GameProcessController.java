import java.util.Scanner;

public class GameProcessController {

    public void launch() {
        System.out.println("Привет!");
        while (true) {
            String answer = wantStartGame();
            if (answer.equals("да"))
                GuessingProcess.start();
            else
                continueGame(answer);
        }
    }

    private static String wantStartGame() {
        System.out.println("Будешь угадывать? (да/нет)");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void continueGame(String answer) {
        if (answer.equals("нет")) {
            System.out.println("(¬_¬ )");
            System.exit(0);
        } else if (!answer.equals("да")) {
            System.out.println("(︶︹︺)\n непонятно. Давай, до свидания!");
            System.exit(0);
        }
        System.out.println("(⌒‿⌒)");
    }
}
