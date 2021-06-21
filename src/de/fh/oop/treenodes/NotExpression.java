package de.fh.oop.treenodes;

import de.fh.oop.util.factory.UnaryFactory;
import de.fh.oop.util.visitor.Visitor4Casting;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Tree;

public class NotExpression implements Expression {

    private Expression myNotExpression = null;

    public Expression getMyNotAssertion() {
        return myNotExpression;
    }

    public NotExpression setMyNotAssertion(final Expression notExpression) {
        myNotExpression = notExpression;
        return this;
    }

    public NotExpression(final Expression notExpression) {
        setMyNotAssertion(notExpression);
    }







    @Override
    public <R, B, C> R acceptVisitor(final Visitor4Tree<R, B, C> v, final B myExpressions, final C i) {
        return v.visit(this, myExpressions, i);
    }

    @Override
    public Expression copy() {
        return UnaryFactory.NOT.create(getMyNotAssertion().copy());
    }

    @Override
    public boolean getLogicalValue() {
        return !getMyNotAssertion().getLogicalValue();
    }

    @Override
    public void print(final String einrueckung) {
        System.out.print(einrueckung + "–");
        getMyNotAssertion().print(einrueckung);

    }

    @Override
    public boolean equalStructure(final Visitor4Equals v, final Expression expression) {
        if (expression.getClass() != this.getClass()) {
            return false;
        }
        return this.myNotExpression.equalStructure(v, ((NotExpression) expression).getMyNotAssertion());
    }

    @Override
    public boolean equalContent(final Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    }

    @Override
    public Boolean equal(final Visitor4Equals v, final Expression exp) {
        return null;
    }

    @Override
    public NotExpression cast(final Visitor4Casting v) {
        return null;
    }

    @Override
    public int size() {
        return getMyNotAssertion().size() + 1;
    }



}
