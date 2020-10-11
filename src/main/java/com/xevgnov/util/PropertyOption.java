package com.xevgnov.util;

public enum PropertyOption {
    KEYWORD_VALUE("keyword.value"),
    FILE_EXTENSION("file.extension");

    private final String name;

    PropertyOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
