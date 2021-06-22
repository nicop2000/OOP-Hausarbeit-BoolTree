package de.fh.oop.treenodes;

import de.fh.oop.util.factory.BinaryFactory;
import de.fh.oop.util.visitor.Visitor4Casting;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Tree;

public class OrExpression extends BinaryExpression {

    public OrExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public <R, B, C> R acceptVisitor(final Visitor4Tree<R, B, C> v, final B myExpressions, final C i) {
        return v.visit(this, myExpressions, i);
    }

    @Override
    public Expression copy() {
        return BinaryFactory.OR.create(this.getLeftBranch().copy(), this.getRightBranch().copy());
    }

    @Override
    public boolean getLogicalValue() {
        return this.getLeftBranch().getLogicalValue() || this.getRightBranch().getLogicalValue();
    }

    @Override
    public void print(final String einrueckung) {
        System.out.println(einrueckung + "||");
        this.getLeftBranch().print(einrueckung + " ");
        this.getRightBranch().print(einrueckung + " ");
    }


    @Override
    public int size() {
        return getLeftBranch().size() + getRightBranch().size() + 1;
    }

    @Override
    public boolean equalStructure(final Visitor4Equals v, final Expression expression) {
        if (expression.getClass() != this.getClass()) {
            return false;
        }

            return this.getLeftBranch().equalStructure(v, ((OrExpression) expression).getLeftBranch()) &&
                    this.getRightBranch().equalStructure(v, ((OrExpression) expression).getRightBranch());
    }


    @Override
    public Boolean equal(final Visitor4Equals v, final Expression exp) {
        return null;
    }

    @Override
    public OrExpression cast(final Visitor4Casting v) {
        return null;
    }


}
