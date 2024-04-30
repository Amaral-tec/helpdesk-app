package com.amaral.helpdesk.enums;

public enum Priority {
    LOW(0, "Low"),
    MEDIUM(1, "Medium"),
    HIGH(2, "High"),
    URGENT(3, "Urgent");

    private Integer code;
    private String description;

    private Priority(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Priority toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (Priority priority : Priority.values()) {
            if (code.equals(priority.getCode())) {
                return priority;
            }
        }

        throw new IllegalArgumentException("Invalid priority code: " + code);
    }
}

