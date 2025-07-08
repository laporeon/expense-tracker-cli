import application.CommandLineInterface;
import controller.ExpenseController;
import enums.Colors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        ExpenseController expenseController = new ExpenseController();
        CommandLineInterface commandLineInterface = new CommandLineInterface();

        while (!exit) {
            commandLineInterface.showMenu();
            System.out.printf("%sChoose an option: %s", Colors.BOLD, Colors.RESET);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    expenseController.add();
                    commandLineInterface.pressEnter(scanner);
                    break;
                case 2:
                    expenseController.list();
                    commandLineInterface.pressEnter(scanner);
                    break;
                case 3:
                    expenseController.delete();
                    commandLineInterface.pressEnter(scanner);
                    break;
                case 4:
                    expenseController.summary();
                    commandLineInterface.pressEnter(scanner);
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
}