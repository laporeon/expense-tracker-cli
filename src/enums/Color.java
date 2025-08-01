package enums;

public enum Color {
    BOLD("\u001B[1m"),
    UNDERLINE("\u001B[4m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    ORANGE("\u001B[38;5;166m"),
    GRAY("\u001B[90m"),
    RESET("\u001B[0m");

    private final String ansiCode;

    Color(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString() {
        return ansiCode;
    }
}