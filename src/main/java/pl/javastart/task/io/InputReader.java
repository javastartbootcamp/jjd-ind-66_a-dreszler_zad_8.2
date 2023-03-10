package pl.javastart.task.io;

import java.util.Scanner;

public class InputReader {
    private Scanner input = new Scanner(System.in);

    public int getInt() {
        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    public void close() {
        input.close();
    }
}
