package me.fayorg.ottoman.commands;

public enum CommandCategory {

    ADMINISTRATOR("administrator", "Administrator"),
    INFORMATION("information", "Information"),
    UNKNOWN("unknown", "Unknown");

    private final String packageName;
    private final String displayName;

    CommandCategory(String packageName, String displayName) {
        this.packageName = packageName;
        this.displayName = displayName;
    }

}
