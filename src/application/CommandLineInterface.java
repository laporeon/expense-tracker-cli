package application;

import controller.ExpenseController;
import enums.Colors;

import java.util.Scanner;

public class CommandLineInterface {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        ExpenseController expenseController = new ExpenseController();

        while (!exit) {
            showMenu();
            System.out.printf("%sChoose an option: %s", Colors.BOLD, Colors.RESET);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    expenseController.add();
                    pressEnter(scanner);
                    break;
                case 2:
                    expenseController.list();
                    pressEnter(scanner);
                    break;
                case 3:
                    expenseController.update();
                    pressEnter(scanner);
                    break;
                case 4:
                    expenseController.delete();
                    pressEnter(scanner);
                    break;
                case 5:
                    expenseController.summary();
                    pressEnter(scanner);
                    break;
                case 0:
                    System.out.println("\nExiting...");
                    exit = true;
                    break;
                default:
                    System.out.printf("%sInvalid option. Try again...%s", Colors.RED, Colors.RESET);
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
                "%s\n", Colors.BLUE, Colors.RESET);
    }

    private void pressEnter(Scanner scanner) {
        System.out.printf("\n%sPress enter to continue... ", Colors.BOLD);
        scanner.nextLine();

        clean();
    }

    private void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
