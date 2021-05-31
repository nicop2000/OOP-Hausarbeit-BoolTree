package de.fhkiel.main;

public class Parser {

    private boolean beforeOperator;

    private String afterOperator;

    public static Assertion parseString(String expression) {
        String[] newString = expression.split("&&", 1);
        parseString(newString[1]);
        return new Value(Boolean.parseBoolean(newString[0]));
    }

    public boolean isBeforeOperator() {
        return beforeOperator;
    }

    public Parser setBeforeOperator(boolean beforeOperator) {
        this.beforeOperator = beforeOperator;
        return this;
    }

    public String getAfterOperator() {
        return afterOperator;
    }

    public Parser setAfterOperator(String afterOperator) {
        this.afterOperator = afterOperator;
        return this;
    }
}
