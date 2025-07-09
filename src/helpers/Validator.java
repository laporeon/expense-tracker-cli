package helpers;

import enums.Color;
import enums.ExpenseField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {
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

    public boolean isValidId(int id, int expensesSize) {
        return id > 0 && id <= expensesSize;
    }

    public Object validateInput(Scanner scanner, String prompt, String errorMessage, ExpenseField attribute) {
        while(true) {
        System.out.print(prompt);

            switch (attribute) {
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
            }

            System.out.printf("%s❌ %s%s\n", Color.RED, errorMessage, Color.RESET);
        }
    }
}
