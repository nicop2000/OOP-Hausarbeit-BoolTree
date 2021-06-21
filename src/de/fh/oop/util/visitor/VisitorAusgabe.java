package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.XorExpression;
import de.fh.oop.treenodes.*;

public class VisitorAusgabe implements Visitor4Tree<String, Void, Void>{

    @Override
    public String visit(final Expression a, final Void myExpressions, final Void i) {
        System.out.println("-ERROR OCCURED: VisitorAusgabe --> visited Expression");
        return null;
    }

    @Override
    public String visit(final AndExpression and, final Void myExpressions, final Void i) {
        return "new AndExpression(" + and.getLeftBranch().acceptVisitor(this, null, null) + ", " +
                and.getRightBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ")";
    }

    @Override
    public String visit(final OrExpression or, final Void myExpressions, final Void i) {
        return "new OrExpression(" + or.getLeftBranch().acceptVisitor(this, null, null) + ", " +
                or.getRightBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ")";
    }

    @Override
    public String visit(final XorExpression xorExpression, final Void myExpressions, final Void i) {
        return "new XorExpression(" + xorExpression.getLeftBranch().acceptVisitor(this, null, null) + ", " +
                xorExpression.getRightBranch().acceptVisitor(new VisitorAusgabe(), null, null) + ")";
    }

    @Override
    public String visit(final NotExpression notExpression, final Void myExpressions, final Void i) {
        return "new NotExpression(" + notExpression.getMyNotAssertion().acceptVisitor(this, null, null) + ")";
    }

    @Override
    public String visit(final Value val, final Void unused, final Void unused2) {
        return "new Value(" + val.getLogicalValue() + ")";
    }
}
