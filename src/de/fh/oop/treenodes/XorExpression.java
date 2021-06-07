package de.fh.oop.treenodes;

import de.fh.oop.util.factory.BinaryFactory;
import de.fh.oop.util.visitor.Visitor4Tree;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Upcasting;
import de.fh.oop.util.visitor.VisitorAusgabe;

import java.util.List;

public class XorExpression extends BinaryExpression {

    public XorExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public boolean getLogicalValue() {
        return getLeftBranch().getLogicalValue() ^ getRightBranch().getLogicalValue();
    }

    @Override
    public Integer acceptVisitor(Visitor4Tree v, List<Expression> myExpressions, int i) {
        return v.visit(this, myExpressions, i);
    }

    @Override
    public Expression copy() {
        return BinaryFactory.XOR.create(this.getLeftBranch(), this.getRightBranch());
    }

    @Override
    public boolean equalStructure(Visitor4Equals v, Expression expression) {
        if(true) {
        return this.getLeftBranch().equals(((XorExpression) expression).getLeftBranch()) &&
                this.getRightBranch().equals(((XorExpression) expression).getRightBranch());
        }
        return false;
    }

    @Override
    public String codeausgabe(VisitorAusgabe v) {
        return v.codeausgabe(this);
    }

    @Override
    public int size() {
        return getLeftBranch().size() + getRightBranch().size() + 1;
    }

    @Override
    public boolean equalContent(Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    }

    @Override
    public void print(String einrueckung) {
        System.out.println("^");
        this.getLeftBranch().print(einrueckung + "  ");
        this.getRightBranch().print(einrueckung + "  ");
    }
}
