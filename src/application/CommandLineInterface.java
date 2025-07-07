package application;

import java.util.Scanner;

public class CommandLineInterface {
    public void showMenu() {
        System.out.println("" +
                "\n" +
                "================================\n" +
                "|         EXPENSE TRACKER      |\n" +
                "================================\n" +
                "| 1 - Add an expense           |\n" +
                "| 2 - List all expenses        |\n" +
                "| 0 - Exit                     |\n" +
                "================================\n" +
                "");
    }

    public void pressEnter(Scanner scanner) {
        System.out.print("\nPress enter to continue... ");
        scanner.nextLine();

        clean();
    }

    public void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
