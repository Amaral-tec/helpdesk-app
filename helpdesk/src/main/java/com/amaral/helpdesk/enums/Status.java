package com.amaral.helpdesk.enums;

public enum Status {
    OPEN(0, "Open"),
    IN_PROGRESS(1, "In Progress"),
    RESOLVED(2, "Resolved"),
    CLOSED(3, "Closed");

    private Integer code;
    private String description;

    private Status(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Status toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (Status status : Status.values()) {
            if (code.equals(status.getCode())) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}
