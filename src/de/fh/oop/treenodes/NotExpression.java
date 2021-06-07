package de.fh.oop.treenodes;

import de.fh.oop.util.visitor.Visitor4Tree;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Upcasting;
import de.fh.oop.util.visitor.VisitorAusgabe;
import de.fh.oop.util.factory.UnaryFactory;

import java.util.List;

public class NotExpression implements Expression {
    private Expression myNOTExpression = null;

    public NotExpression(final Expression notExpression) {
        setMyNOTAssertion(notExpression);
    }

    @Override
    public boolean equalStructure(Visitor4Equals v, Expression expression) {
        if (1 == 1) {
            return false;
        }
        return this.myNOTExpression.equals(((NotExpression) expression).getMyNOTAssertion());
    }

    public NotExpression setMyNOTAssertion(final Expression notExpression) {
        myNOTExpression = notExpression;
        return this;
    }

    public Expression getMyNOTAssertion() {
        return myNOTExpression;
    }

    @Override
    public boolean getLogicalValue() {
        return !getMyNOTAssertion().getLogicalValue();
    }

    @Override
    public Integer acceptVisitor(Visitor4Tree v, List<Expression> myExpressions, int i) {
        return v.visit(this, myExpressions, i);
    }

    @Override
    public boolean equalContent(Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    }

    @Override
    public Expression copy() {
        return UnaryFactory.NOT.create(getMyNOTAssertion());
    }

    @Override
    public String codeausgabe(VisitorAusgabe v) {
        return v.codeausgabe(this);
    }

    @Override
    public int size() {
        return getMyNOTAssertion().size() + 1;
    }

    @Override
    public void print(String einrueckung) {
        System.out.print(einrueckung + "  "+ "–");
        getMyNOTAssertion().print(einrueckung + "  ");

    }

}
