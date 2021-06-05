package de.fhkiel.main;

public class XOR extends BinaryAssertion {

    XOR(Assertion left, Assertion right) {
        super(left, right);
    }

    @Override
    public boolean getLogicalValue() {
        return getLeftBranch().getLogicalValue() ^ getRightBranch().getLogicalValue();
    }


    @Override
    public String acceptVisitor(Visitor v) {
        return v.visit(this);
    }

    @Override
    public void codeausgabe(VisitorAusgabe v) {
        v.codeausgabe(this);
    }

    @Override
    public int size() {
        int c = getLeftBranch().size() + getRightBranch().size() + 1;
        return c;
    }

    @Override
    public void print(String einrueckung) {
        System.out.println("^");
        this.getLeftBranch().print(einrueckung + "  ");
        this.getRightBranch().print(einrueckung + "  ");
    }
}
