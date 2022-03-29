package me.fayorg.ottoman.commands;

public enum CommandEnabled {

    ENABLED(0),
    DISABLED(1),
    ADMIN(2);

    private final int value;

    CommandEnabled(int value) {
        this.value = value;
    }
}
