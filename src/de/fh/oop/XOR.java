package de.fh.oop;

import java.util.List;

public class XOR extends BinaryAssertion {

    XOR(Assertion left, Assertion right) {
        super(left, right);
    }

    @Override
    public boolean getLogicalValue() {
        return getLeftBranch().getLogicalValue() ^ getRightBranch().getLogicalValue();
    }


    @Override
    public Integer acceptVisitor(Visitor v, List<Assertion> myAssertions, int i) {
        return v.visit(this, myAssertions, i);
    }

    @Override
    public void codeausgabe(VisitorAusgabe v) {
        v.codeausgabe(this);
    }

    @Override
    public int size() {
        return getLeftBranch().size() + getRightBranch().size() + 1;
    }

    @Override
    public void print(String einrueckung) {
        System.out.println("^");
        this.getLeftBranch().print(einrueckung + "  ");
        this.getRightBranch().print(einrueckung + "  ");
    }
}
