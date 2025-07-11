package helpers;

import controller.FileController;
import enums.Color;
import enums.ExpenseField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {
    private final Scanner scanner = new Scanner(System.in);

    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    private boolean isValidDescription(String description) {
        return description != null && !description.trim().isEmpty() && (description.trim().length() >= 3 && description.trim().length() <= 30);
    }

    private boolean isValidId(int id) {
        int expensesSize = new FileController().readFile().size();
        return id > 0 && id <= expensesSize;
    }

    public Object validateInput(String prompt, String errorMessage, ExpenseField expenseField) {
        while(true) {
        System.out.print(prompt);

            switch (expenseField) {
                case AMOUNT:
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (isValidAmount(amount)) return amount;
                    break;
                case DESCRIPTION:
                    String description = scanner.nextLine();
                    if (isValidDescription(description)) return description;
                    break;
                case DATE:
                    String date = scanner.nextLine();
                    if (isValidDate(date)) return date;
                    break;
                case ID:
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (isValidId(id)) return id;
                    break;
            }

            System.out.printf("%s❌ %s%s\n", Color.RED, errorMessage, Color.RESET);
        }
    }
}
