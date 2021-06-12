package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.AndExpression;
import de.fh.oop.treenodes.Expression;

public class Visitor4Casting {

    public AndExpression visit(AndExpression and, AndExpression and2) {
        return and2;
    }

    public AndExpression visit(AndExpression and) {
        return and;
    }

    public Expression visit(Expression exp, Expression exp2) {
        return exp;
    }
}
