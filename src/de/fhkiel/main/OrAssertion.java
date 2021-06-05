package de.fhkiel.main;

public class OrAssertion extends BinaryAssertion {

    OrAssertion(Assertion left, Assertion right) {
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
        int a = getLeftBranch().size() + getRightBranch().size() + 1;
        return a;
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
    public boolean getLogicalValue() {
        return this.getLeftBranch().getLogicalValue() || this.getRightBranch().getLogicalValue();
    }
}
