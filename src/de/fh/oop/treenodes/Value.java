package de.fh.oop.treenodes;

import de.fh.oop.util.visitor.Visitor4Casting;
import de.fh.oop.util.visitor.Visitor4Tree;
import de.fh.oop.util.visitor.Visitor4Equals;

import de.fh.oop.util.visitor.VisitorAusgabe;
import de.fh.oop.util.factory.ValueFactory;

import java.util.List;

public class Value implements Expression {

    private boolean value = false;

    public Value(final boolean value) {
        setValue(value);
    }


    @Override
    public boolean getLogicalValue() {
        return isValue();
    }

    @Override
    public <R, B, C> R acceptVisitor(final Visitor4Tree<R, B, C> v, final B myExpressions, final C i) {
        return v.visit(this, myExpressions, i);
    }

    @Override
    public Expression copy() {
        return ValueFactory.VALUE.create(getLogicalValue());
    }

    @Override
    public boolean equalStructure(final Visitor4Equals v, final Expression expression) {
        if (expression.getClass() != this.getClass()) {
            return false;
        }
        return this.getLogicalValue() == expression.getLogicalValue();
    }

    @Override
    public void print(final String einrueckung) {
        System.out.println(einrueckung + getLogicalValue());
    }

    @Override
    public boolean equalContent(final Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    }

    @Override
    public int size() {
        return 1;
    }



    @Override
    public Boolean equal(final Visitor4Equals v, final Expression exp) {
        return null;
    }

//    @Override
    public Expression cast(final Visitor4Casting v) {
        return null;
    }


    private Value setValue(final boolean value) {
        this.value = value;
        return this;
    }

    public boolean isValue() {
        return value;
    }
}
