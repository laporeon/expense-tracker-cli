package controller;

import entity.Expense;
import enums.Color;
import enums.ExpenseField;
import helpers.Validator;

import java.util.List;

public class ExpenseController {
    Validator validator = new Validator();
    FileController fileController = new FileController();

    public void add() {
        List<Expense> expenses = fileController.readFile();

        System.out.print("\n\n");
        double amount = (double) validator.validateInput(ExpenseField.AMOUNT.getPromptMessage(),
                ExpenseField.AMOUNT.getErrorMessage(), ExpenseField.AMOUNT);
        String description = (String) validator.validateInput(ExpenseField.DESCRIPTION.getPromptMessage(),
                ExpenseField.DESCRIPTION.getErrorMessage(), ExpenseField.DESCRIPTION);
        String date = (String) validator.validateInput(ExpenseField.DATE.getPromptMessage(),
                ExpenseField.DATE.getErrorMessage(), ExpenseField.DATE);
        Expense expense = new Expense(expenses.size() + 1, amount, description, date);

        fileController.saveToFile(expense);

        System.out.printf("\n%s✓ Expense successfully added! (ID: %d) %s%n", Color.GREEN, expense.getId(), Color.RESET);
    }

    public void list() {
        System.out.printf("\n%s%-5s %-20s %-10s %-12s%s\n%s\n", Color.BOLD, "ID", "DESCRIPTION", "AMOUNT", "DATE",
                Color.RESET, "--------------------------------------------------");

        List<Expense> expenses = fileController.readFile();

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        expenses.forEach(System.out::println);
    }

    public void update() {
        System.out.print("\n\n");
        int id = (int) validator.validateInput(ExpenseField.ID.getPromptMessage(), ExpenseField.ID.getErrorMessage(),
                ExpenseField.ID);

        List<Expense> expenses = fileController.readFile();

        Expense expense = expenses.stream().filter(exp -> exp.getId() == id).findFirst().get();

        double newAmount = (double) validator.validateInput("Enter new amount: ",
                ExpenseField.AMOUNT.getErrorMessage(), ExpenseField.AMOUNT);
        String newDescription = (String) validator.validateInput("Enter new description: ",
                ExpenseField.DESCRIPTION.getErrorMessage(), ExpenseField.DESCRIPTION);
        String newDate = (String) validator.validateInput("Enter new date (i.e yyyy-MM-dd): ",
                ExpenseField.DATE.getErrorMessage(), ExpenseField.DATE);

        expense.setAmount(newAmount);
        expense.setDescription(newDescription);
        expense.setDate(newDate);

        fileController.updateFile(expenses);

        System.out.printf("\n%s✓ Expense successfully updated! %s%n", Color.GREEN, Color.RESET);
    }

    public void delete() {
        System.out.print("\n\n");
        int id = (int) validator.validateInput(ExpenseField.ID.getPromptMessage(), ExpenseField.ID.getErrorMessage(),
                ExpenseField.ID);

        List<Expense> expenses = fileController.readFile();

        expenses.removeIf(expense -> expense.getId() == id);
        fileController.updateFile(expenses);
        System.out.printf("\n%s✓ Expense successfully deleted!%s%n", Color.GREEN, Color.RESET);
    }

    public void summary() {
        List<Expense> expenses = fileController.readFile();

        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();

        System.out.printf("\n%sTotal expenses: $ %.2f%s\n", Color.GREEN, total, Color.RESET);
    }

}
