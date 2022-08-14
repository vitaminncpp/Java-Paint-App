package com.util;

public class MathException extends Exception {

    public static String DIMENSION_MISMATCH_EXCEPTION = "Dimension missmatch Exception";

    private final String type;

    public MathException(String msg, String type) {
        super(msg);
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type + " : " + super.toString();
    }
}
