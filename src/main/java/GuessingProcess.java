import java.util.Random;
import java.util.Scanner;

public class GuessingProcess {

    public static void start() {
        int targetNumber = setTargetNumber();

        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();

        while(answer != targetNumber) {
            if (answer < 1 || answer > 10)
                System.out.println("Читать не умеешь?");
            else if (Math.abs(answer - targetNumber) > 5)
                System.out.println("Холодно");
            else if (Math.abs(answer - targetNumber) > 2)
                System.out.println("Тепло");
            else
                System.out.println("Жгётся!");

            answer = sc.nextInt();
        }
        System.out.println(("╰(▔∀▔)╯"));
    }

    private static int setTargetNumber() {
        System.out.println("угадай число от 1 до 10");
        return new Random().nextInt(0, 10) + 1;
    }
}
