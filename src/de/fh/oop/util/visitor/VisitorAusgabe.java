package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

import java.util.List;

public class VisitorAusgabe implements Visitor4Tree<String, Void, Void>{

    @Override
    public String visit(final Expression a, final Void myExpressions, final Void i) {
        return null;
    }

    @Override
    public String visit(final AndExpression and, final Void myExpressions, final Void i) {
        return "new AndExpression(" + and.getLeftBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ", " +
                and.getRightBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ")";
    }

    @Override
    public String visit(final OrExpression or, final Void myExpressions, final Void i) {
        return "new OrExpression(" + or.getLeftBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ", " +
                or.getRightBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ")";
    }

    @Override
    public String visit(final XorExpression xorExpression, final Void myExpressions, final Void i) {
        return "new XorExpression(" + xorExpression.getLeftBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ", " +
                xorExpression.getRightBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ")";
    }

    @Override
    public String visit(final NotExpression notExpression, final Void myExpressions, final Void i) {
        return "new NotExpression(" + notExpression.getMyNOTAssertion().acceptVisitor(new VisitorAusgabe(), null, null) + ")";
    }

    @Override
    public String visit(final Value val, final Void unused, final Void unused2) {
        return "new Value(" + val.getLogicalValue() + ")";
    }
}
