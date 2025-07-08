package application;

import enums.Colors;

import java.util.Scanner;

public class CommandLineInterface {
    public void showMenu() {
        System.out.printf("%s" +
                "\n" +
                "================================\n" +
                "|         EXPENSE TRACKER      |\n" +
                "================================\n" +
                "| 1 - Add an expense           |\n" +
                "| 2 - List all expenses        |\n" +
                "| 3 - Delete an expense        |\n" +
                "| 4 - Summary of expenses      |\n" +
                "| 0 - Exit                     |\n" +
                "================================\n" +
                "%s\n", Colors.BLUE, Colors.RESET);
    }

    public void pressEnter(Scanner scanner) {
        System.out.printf("\n%sPress enter to continue... ", Colors.BOLD);
        scanner.nextLine();

        clean();
    }

    public void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
