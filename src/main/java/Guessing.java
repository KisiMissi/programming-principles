/**
 * Тут, короче, наскоряк накиданная клёвая игра в угадайку.
 * Оно число загадывает, а пользователь потом угадывает.
 * Есть подсказки, на сколько далеко.
 * todo: DRY, KISS, SOLID (точно можно на ООП-шить), и опечатки по мелочи
 */
public class Guessing {

    public static void main(String[] args) {
        GameProcessController gameController = new GameProcessController();
        gameController.launch();
    }
}