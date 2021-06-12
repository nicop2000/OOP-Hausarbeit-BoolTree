package de.fh.oop.treenodes;

import de.fh.oop.util.visitor.Visitor4Casting;
import de.fh.oop.util.visitor.Visitor4Tree;
import de.fh.oop.util.visitor.Visitor4Equals;

import de.fh.oop.util.visitor.VisitorAusgabe;
import de.fh.oop.util.factory.UnaryFactory;

import java.util.List;

public class NotExpression implements Expression {
    private Expression myNOTExpression = null;

    public NotExpression(final Expression notExpression) {
        setMyNOTAssertion(notExpression);
    }

    @Override
    public boolean equalStructure(final Visitor4Equals v, final Expression expression) {
        if (expression.getClass() != this.getClass()) {
            return false;
        }
        return this.myNOTExpression.equalStructure(v, ((NotExpression) expression).getMyNOTAssertion());
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
    public <R, B, C> R acceptVisitor(final Visitor4Tree<R, B, C> v, final B myExpressions, final C i) {
        return v.visit(this, myExpressions, i);
    }

    @Override
    public boolean equalContent(final Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    }

    @Override
    public Boolean equal(final Visitor4Equals v, final Expression exp) {
        return null;
    }

//    @Override
    public NotExpression cast(final Visitor4Casting v) {
        return null;
    }

    @Override
    public Expression copy() {
        return UnaryFactory.NOT.create(getMyNOTAssertion());
    }

//    @Override
//    public String codeausgabe(VisitorAusgabe v) {
//        return v.codeausgabe(this);
//    }

    @Override
    public int size() {
        return getMyNOTAssertion().size() + 1;
    }

    @Override
    public void print(final String einrueckung) {
        System.out.print("–");
        getMyNOTAssertion().print(einrueckung);

    }

}
