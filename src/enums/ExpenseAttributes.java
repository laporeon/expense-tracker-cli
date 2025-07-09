package enums;

public enum ExpenseAttributes {
    AMOUNT("amount"),
    DESCRIPTION("description"),
    DATE("date");

    private final String attribute;

    ExpenseAttributes(String ansiCode) {
        this.attribute = ansiCode;
    }

    @Override
    public String toString() {
        return attribute;
    }
}
