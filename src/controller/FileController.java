package controller;

import entity.Expense;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private static final String FILE_HEADER = "ID;AMOUNT;DESCRIPTION;DATE";
    private static final Path FILE_PATH = Paths.get("files", "expenses.txt");

    public List<Expense> readFile() {
        List<Expense> expenses = new ArrayList<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(FILE_PATH)) {
            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(";");

                int id = Integer.parseInt(attributes[0]);
                double amount = Double.parseDouble(attributes[1]);
                String description = attributes[2];
                String date = attributes[3];

                Expense expense = new Expense(id, amount, description, date);
                expenses.add(expense);
            }

            return expenses;
        } catch (IOException exception) {
            throw new RuntimeException("Error while trying to read file: " + exception.getMessage(), exception);
        }
    }

    public void saveToFile(Expense expense) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(FILE_PATH, StandardOpenOption.APPEND)) {
            String expenseString = expense.toCsvString();
            bufferedWriter.write(expenseString);
        } catch (IOException exception) {
            throw new RuntimeException("Error while trying to save file: " + exception.getMessage(), exception);
        }
    }

    public void updateFile(List<Expense> expenses) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(FILE_PATH)) {
            bufferedWriter.write(FILE_HEADER);

            for (Expense expense : expenses) {
                String expenseString = expense.toCsvString();
                bufferedWriter.write(expenseString);
            }
        } catch (IOException exception) {
            throw new RuntimeException("Error while trying to update file: " + exception.getMessage(), exception);
        }
    }
}
