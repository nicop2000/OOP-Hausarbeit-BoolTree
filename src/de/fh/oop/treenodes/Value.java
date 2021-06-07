package de.fh.oop.treenodes;

import de.fh.oop.util.visitor.Visitor4Tree;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Upcasting;
import de.fh.oop.util.visitor.VisitorAusgabe;
import de.fh.oop.util.factory.ValueFactory;

import java.util.List;

public class Value implements Expression {

    private boolean value = false;

    public Value(boolean value) {
        setValue(value);
    }


    @Override
    public boolean getLogicalValue() {
        return isValue();
    }

    @Override
    public Integer acceptVisitor(Visitor4Tree v, List<Expression> myExpressions, int i) {
        return v.visit(this, myExpressions, i);
    }

    @Override
    public Expression copy() {
        return ValueFactory.VALUE.create(getLogicalValue());
    }

    @Override
    public boolean equalStructure(Visitor4Equals v, Expression expression) {
        if (1 == 1) {
        return this.getLogicalValue() == expression.getLogicalValue();
        }
            return false;
    }

    @Override
    public void print(String einrueckung) {
        System.out.println(einrueckung + getLogicalValue());
    }

    @Override
    public boolean equalContent(Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String codeausgabe(VisitorAusgabe v) {
        return v.codeausgabe(this);
    }


    private Value setValue(final boolean value) {
        this.value = value;
        return this;
    }

    public boolean isValue() {
        return value;
    }
}
