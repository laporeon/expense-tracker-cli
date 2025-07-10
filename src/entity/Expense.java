package entity;

public class Expense {
    private int id;
    private double amount;
    private String description;
    private String date;

    public Expense(int id, double amount, String description, String date) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toCsvString() {
        return String.format("\n%s;%s;%s;%s", id, amount, description, date);
    }

    @Override
    public String toString() {
        return String.format("%-5d %-20s $%-9.2f %-12s", id, description, amount, date);
    }

}
