package controller;

import entity.Expense;
import helpers.Validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseController {
    public List<Expense> expenses = new ArrayList<Expense>();

    Validator validator = new Validator();

    Scanner scanner = new Scanner(System.in);

    public void add() {
        System.out.print("\n\n");
        System.out.print("Enter expense amount: ");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        String date;
        do {
            System.out.print("Enter date (i.e YYYY/MM/DD): ");
            date = scanner.nextLine();
            if (!validator.isValidDate(date)) {
                System.out.println("❌ Invalid date format! Please use YYYY/MM/DD (e.g., 2025/07/07)");
            }
        } while (!validator.isValidDate(date));
        Expense expense = new Expense(expenses.size() + 1, amount, description, date);
        expenses.add(expense);
        System.out.println("\nExpense successfully added!");
    }

    public List<Expense> list() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return expenses;
        }

        System.out.println("\n------------ ALL EXPENSES ------------");
        for (Expense expense : expenses) {
            System.out.println("ID: " + expense.getId() +
                    " | Amount: $" + expense.getAmount() +
                    " | Description: " + expense.getDescription() +
                    " | Date: " + expense.getDate());
        }
        System.out.println("------------------------\n");
        return expenses;
    }
}
