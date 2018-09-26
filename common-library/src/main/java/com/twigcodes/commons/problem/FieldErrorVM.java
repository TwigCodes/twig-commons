package com.twigcodes.commons.problem;

import java.io.Serializable;

class FieldErrorVM implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String objectName;

    private final String field;

    private final String message;

    public FieldErrorVM(String objectName, String field, String message) {
        this.objectName = objectName;
        this.field = field;
        this.message = message;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @return the objectName
     */
    public String getObjectName() {
        return objectName;
    }
}
