package enums;

public enum ExpenseField {
    ID("Enter amount ID: ", "Invalid or missing id! Try again..."),
    AMOUNT("Enter amount: ", "Invalid amount!"),
    DESCRIPTION("Enter description: ", "Invalid description! Description cannot be null and must have at least 3 characters"),
    DATE("Enter date (i.e yyyy-MM-dd): ", "Invalid date format! Please use yyyy-MM-dd (e.g., 2025-07-07)");

    private final String promptMessage;
    private final String errorMessage;

    ExpenseField(String promptMessage, String errorMessage) {
        this.promptMessage = promptMessage;
        this.errorMessage = errorMessage;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
