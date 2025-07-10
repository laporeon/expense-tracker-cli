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
                ExpenseField.AMOUNT.getErrorMessage(), ExpenseField.AMOUNT, expenses.size());
        String description = (String) validator.validateInput(scanner, ExpenseField.DESCRIPTION.getPromptMessage(),
                ExpenseField.DESCRIPTION.getErrorMessage(), ExpenseField.DESCRIPTION, expenses.size());
        String date = (String) validator.validateInput(scanner, ExpenseField.DATE.getPromptMessage(),
                ExpenseField.DATE.getErrorMessage(), ExpenseField.DATE, expenses.size());
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
        int id = (int) validator.validateInput(scanner, ExpenseField.ID.getPromptMessage(),
                ExpenseField.ID.getErrorMessage(), ExpenseField.ID, expenses.size());

        Expense expense = expenses.get(id - 1);

        double newAmount = (double) validator.validateInput(scanner, "Enter new amount: ",
                ExpenseField.AMOUNT.getErrorMessage(), ExpenseField.AMOUNT, expenses.size());
        String newDescription = (String) validator.validateInput(scanner, "Enter new description: ",
                ExpenseField.DESCRIPTION.getErrorMessage(), ExpenseField.DESCRIPTION, expenses.size());
        String newDate = (String) validator.validateInput(scanner, "Enter new date (i.e yyyy-MM-dd): ",
                ExpenseField.DATE.getErrorMessage(), ExpenseField.DATE, expenses.size());

        expense.setAmount(newAmount);
        expense.setDescription(newDescription);
        expense.setDate(newDate);

        System.out.printf("\n%s✓ Expense successfully updated! %s%n", Color.GREEN, Color.RESET);
    }

    public void delete() {
        System.out.print("\n\n");
        int id = (int) validator.validateInput(scanner, ExpenseField.ID.getPromptMessage(),
                ExpenseField.ID.getErrorMessage(), ExpenseField.ID, expenses.size());

        expenses.remove(id - 1);
        System.out.printf("\n%s✓ Expense successfully deleted!%s%n", Color.GREEN, Color.RESET);
    }

    public void summary() {
        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();

        System.out.printf("\n%sTotal expenses: $ %.2f%s\n", Color.GREEN, total, Color.RESET);
    }

}
