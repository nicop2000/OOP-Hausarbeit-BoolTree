package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.XorExpression;
import de.fh.oop.treenodes.*;

public class VisitorCodeausgabe implements Visitor4Tree<String, Void, Void>{

    /*
     * Gibt den Code zur Instanziierung eines Objektes aus
     */

    @Override
    public String visit(final Expression a, final Void myExpressions, final Void i) {
        throw new IllegalArgumentException("--Error occured-- --Found Expression in VisitorCodeausgabe--");
    }

    @Override
    public String visit(final AndExpression and, final Void myExpressions, final Void i) {
        return "new AndExpression(" + and.getLeftBranch().acceptVisitor(this, null, null) + ", " +
                and.getRightBranch().acceptVisitor(new VisitorCodeausgabe(), null, null) + ")";
    }

    @Override
    public String visit(final OrExpression or, final Void myExpressions, final Void i) {
        return "new OrExpression(" + or.getLeftBranch().acceptVisitor(this, null, null) + ", " +
                or.getRightBranch().acceptVisitor(new VisitorCodeausgabe(), null, null) + ")";
    }

    @Override
    public String visit(final XorExpression xorExpression, final Void myExpressions, final Void i) {
        return "new XorExpression(" + xorExpression.getLeftBranch().acceptVisitor(this, null, null) + ", " +
                xorExpression.getRightBranch().acceptVisitor(new VisitorCodeausgabe(), null, null) + ")";
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
