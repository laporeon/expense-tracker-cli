import application.CommandLineInterface;
import controller.ExpenseController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        ExpenseController expenseController = new ExpenseController();
        CommandLineInterface commandLineInterface = new CommandLineInterface();

        while (!exit) {
            commandLineInterface.showMenu();
            System.out.print("Choose an option: ");
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
                case 0:
                    System.out.println("\nExiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again...");
                    break;
            }
        }
        scanner.close();
    }
}