package enums;

public enum ExpenseField {
    AMOUNT("Enter amount: ", "Invalid amount!", Double.class),
    DESCRIPTION("Enter description: ", "Invalid description! Description cannot be null and must have at least 3 characters", String.class),
    DATE("Enter date (i.e yyyy-MM-dd): ", "Invalid date format! Please use yyyy-MM-dd (e.g., 2025-07-07)", String.class);

    private final String promptMessage;
    private final String errorMessage;
    private final Class<?> type;

    ExpenseField(String promptMessage, String errorMessage, Class<?> type) {
        this.promptMessage = promptMessage;
        this.errorMessage = errorMessage;
        this.type = type;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Class<?> getType() {
        return type;
    }
}
