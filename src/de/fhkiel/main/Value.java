package de.fhkiel.main;

public class Value implements Assertion{

    private boolean value = false;

    Value (boolean value) {
        setValue(value);
    }

    Value() {

    }

    @Override
    public boolean getLogicalValue() {
        return isValue();
    }

    @Override
    public void print() {
        System.out.print(getLogicalValue());

    }

    private Value setValue(final boolean value) {
        this.value = value;
        return this;
    }

    public boolean isValue() {
        return value;
    }
}
