package de.fh.oop;

import java.util.List;

public class AndAssertion extends BinaryAssertion {

    @Override
    public int size() {
        return getLeftBranch().size() + getRightBranch().size() + 1;

    }

    AndAssertion(Assertion left, Assertion right) {
        super(left, right);
    }

    @Override
    public void print(String einrueckung) {

        System.out.println(einrueckung + "&&");
        this.getLeftBranch().print(einrueckung + "  ");
        this.getRightBranch().print(einrueckung + "  ");
    }

    @Override
    public void codeausgabe(VisitorAusgabe v) {
        v.codeausgabe(this);
    }

    @Override
    public Integer acceptVisitor(Visitor v, List<Assertion> myAssertions, int i) {
       return v.visit(this, myAssertions, i);
    }

    @Override
    public boolean getLogicalValue() {
        return this.getLeftBranch().getLogicalValue() && this.getRightBranch().getLogicalValue();
    }
}
