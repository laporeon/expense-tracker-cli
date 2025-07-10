package application;

import controller.ExpenseController;
import enums.Color;

import java.util.Scanner;

public class CommandLineInterface {

    Scanner scanner = new Scanner(System.in);
    ExpenseController expenseController = new ExpenseController();

    public void start() {
        boolean exit = false;
        
        while (!exit) {
            showMenu();
            System.out.printf("%sChoose an option: %s", Color.BOLD, Color.RESET);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    expenseController.add();
                    pressEnter();
                    break;
                case 2:
                    expenseController.list();
                    pressEnter();
                    break;
                case 3:
                    expenseController.update();
                    pressEnter();
                    break;
                case 4:
                    expenseController.delete();
                    pressEnter();
                    break;
                case 5:
                    expenseController.summary();
                    pressEnter();
                    break;
                case 0:
                    System.out.println("\nExiting...");
                    exit = true;
                    break;
                default:
                    System.out.printf("%sInvalid option. Try again...%s", Color.RED, Color.RESET);
                    break;
            }
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.printf("%s" +
                "\n" +
                "================================\n" +
                "|         EXPENSE TRACKER      |\n" +
                "================================\n" +
                "| 1 - Add an expense           |\n" +
                "| 2 - List all expenses        |\n" +
                "| 3 - Update an expense        |\n" +
                "| 4 - Delete an expense        |\n" +
                "| 5 - Summary of expenses      |\n" +
                "| 0 - Exit                     |\n" +
                "================================\n" +
                "%s\n", Color.BLUE, Color.RESET);
    }

    private void pressEnter() {
        System.out.printf("\n%sPress enter to continue... ", Color.BOLD);
        scanner.nextLine();

        clean();
    }

    private void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
