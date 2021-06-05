package de.fhkiel.main;

public class Value implements Assertion{

    private boolean value = false;

    Value (boolean value) {
        setValue(value);
    }


    @Override
    public boolean getLogicalValue() {
        return isValue();
    }

    @Override
    public String acceptVisitor(Visitor v) {
        return v.visit(this);
    }

    @Override
    public void print(String einrueckung) {
        System.out.println(einrueckung + getLogicalValue());

    }
    @Override
    public int size() {
        return 1;
    }

    @Override
    public void codeausgabe(VisitorAusgabe v) {
        v.codeausgabe(this);
    }

    private Value setValue(final boolean value) {
        this.value = value;
        return this;
    }

    public boolean isValue() {
        return value;
    }
}
