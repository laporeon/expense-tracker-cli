package controller;

import entity.Expense;
import enums.Color;
import enums.ExpenseField;
import helpers.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseController {
    public List<Expense> expenses = new ArrayList<Expense>();

    Validator validator = new Validator();

    Scanner scanner = new Scanner(System.in);

    public void add() {
        System.out.print("\n\n");
        double amount = (double) validator.validateInput(scanner, ExpenseField.AMOUNT.getPromptMessage(),
                ExpenseField.AMOUNT.getErrorMessage(), ExpenseField.AMOUNT);
        String description = (String) validator.validateInput(scanner, ExpenseField.DESCRIPTION.getPromptMessage(),
                ExpenseField.DESCRIPTION.getErrorMessage(), ExpenseField.DESCRIPTION);
        String date = (String) validator.validateInput(scanner, ExpenseField.DATE.getPromptMessage(),
                ExpenseField.DATE.getErrorMessage(), ExpenseField.DATE);
        Expense expense = new Expense(expenses.size() + 1, amount, description, date);
        expenses.add(expense);
        System.out.printf("\n%s✓ Expense successfully added! (ID: %d) %s%n", Color.GREEN, expense.getId(), Color.RESET);
    }

    public void list() {
        System.out.printf("\n%s%-5s %-20s %-10s %-12s%s\n%s\n", Color.BOLD, "ID", "DESCRIPTION", "AMOUNT", "DATE",
                Color.RESET, "--------------------------------------------------");

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        expenses.forEach(System.out::println);
    }

    public void update() {
        System.out.print("\n\n");
        System.out.print("Enter the ID of the expense you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!validator.isValidId(id, expenses.size())) {
            System.out.printf("%s❌ Invalid or missing ID.%s\n", Color.RED, Color.RESET);
            return;
        }

        Expense expense = expenses.get(id - 1);

        double newAmount = (double) validator.validateInput(scanner, "Enter new amount: ",
                ExpenseField.AMOUNT.getErrorMessage(), ExpenseField.AMOUNT);
        String newDescription = (String) validator.validateInput(scanner, "Enter new description: ",
                ExpenseField.DESCRIPTION.getErrorMessage(), ExpenseField.DESCRIPTION);
        String newDate = (String) validator.validateInput(scanner, "Enter new date (i.e yyyy-MM-dd): ",
                ExpenseField.DATE.getErrorMessage(), ExpenseField.DATE);

        expense.setAmount(newAmount);
        expense.setDescription(newDescription);
        expense.setDate(newDate);

        System.out.printf("\n%s✓ Expense successfully updated! %s%n", Color.GREEN, Color.RESET);
    }

    public void delete() {
        System.out.print("\n\n");
        System.out.print("Enter expense ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!validator.isValidId(id, expenses.size())) {
            System.out.printf("%s❌ Invalid or missing ID.%s\n", Color.RED, Color.RESET);
            return;
        }

        expenses.remove(id - 1);
        System.out.printf("\n%s✓ Expense successfully deleted!%s%n", Color.GREEN, Color.RESET);
    }

    public void summary() {
        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();

        System.out.printf("\n%sTotal expenses: $ %.2f%s\n", Color.GREEN, total, Color.RESET);
    }

}
