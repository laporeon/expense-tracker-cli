package controller;

import entity.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private static final String FILE_HEADER = "ID;AMOUNT;DESCRIPTION;DATE";
    private static final String FILE_PATH = "src/files/expenses.txt";
    private final File file = new File(FILE_PATH);

    public List<Expense> readFile() {
        List<Expense> expenses = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
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
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            String expenseString = expense.toCsvString();
            bufferedWriter.write(expenseString);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void updateFile(List<Expense> expenses) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(FILE_HEADER);

            for (Expense expense : expenses) {
                String expenseString = expense.toCsvString();
                bufferedWriter.write(expenseString);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
