package de.fh.oop.treenodes;

import de.fh.oop.util.factory.BinaryFactory;
import de.fh.oop.util.visitor.Visitor4Tree;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Upcasting;
import de.fh.oop.util.visitor.VisitorAusgabe;

import java.util.List;

public class OrExpression extends BinaryExpression {

    public OrExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public void print(String einrueckung) {
        System.out.println("||");
        this.getLeftBranch().print(einrueckung);
        this.getRightBranch().print(einrueckung);
    }

    @Override
    public int size() {
        return getLeftBranch().size() + getRightBranch().size() + 1;
    }

    @Override
    public boolean equalStructure(Visitor4Equals v, Expression expression) {
        if (1 == 1) {

            return this.getLeftBranch().equals(((OrExpression) expression).getLeftBranch()) &&
                    this.getRightBranch().equals(((OrExpression) expression).getRightBranch());
        }
        return false;
    }

    @Override
    public Expression copy() {
        return BinaryFactory.OR.create(this.getLeftBranch(), this.getRightBranch());
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
    public String codeausgabe(VisitorAusgabe v) {
        return v.codeausgabe(this);
    }

    @Override
    public boolean getLogicalValue() {
        return this.getLeftBranch().getLogicalValue() || this.getRightBranch().getLogicalValue();
    }
}
