package io;

import java.util.Scanner;

public class MessagesReader {

    private final Scanner sc;

    public MessagesReader() {
        sc = new Scanner(System.in);
    }

    public String readAnswer() {
        return sc.nextLine();
    }

    public int readNum() {
        return sc.nextInt();
    }
}
