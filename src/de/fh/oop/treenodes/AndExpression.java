package de.fh.oop.treenodes;

import de.fh.oop.util.factory.BinaryFactory;
import de.fh.oop.util.visitor.Visitor4Casting;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Tree;

public class AndExpression extends BinaryExpression {

    public AndExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public <R, B, C> R acceptVisitor(Visitor4Tree<R, B, C> v, B myExpressions, C i) {
        return v.visit(this, myExpressions, i);
    }

    @Override
    public Expression copy() {
        return BinaryFactory.AND.create(this.getLeftBranch().copy(), this.getRightBranch().copy());
    }

    @Override
    public boolean getLogicalValue() {
        return this.getLeftBranch().getLogicalValue() && this.getRightBranch().getLogicalValue();
    }

    @Override
    public void print(final String einrueckung) {
        System.out.println(einrueckung + "&&");
        this.getLeftBranch().print(einrueckung + " ");
        this.getRightBranch().print(einrueckung + " ");
    }






    @Override
    public int size() {
        return getLeftBranch().size() + getRightBranch().size() + 1;
    }



    @Override
    public boolean equalStructure(final Visitor4Equals v, final Expression expression) {
        if (/*v.visit(this, expression)*/expression.getClass() != this.getClass()) {
            return false;
        }
        return this.getLeftBranch().equalStructure(v, ((AndExpression) expression).getLeftBranch()) &&
                this.getRightBranch().equalStructure(v, ((AndExpression) expression).getRightBranch());

    }


    @Override
    public Boolean equal(final Visitor4Equals v, final Expression exp) {
        return false /*v.visit(this, exp.cast(new Visitor4Casting()))*/;
    }

    @Override
    public AndExpression cast(final Visitor4Casting v) {
        return v.visit(this);
    }




}
