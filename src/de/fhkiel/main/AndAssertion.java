package de.fhkiel.main;

public class AndAssertion extends BinaryAssertion {

    @Override
    public int size() {
        int b = getLeftBranch().size() + getRightBranch().size() + 1;
        return b;
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
    public String acceptVisitor(Visitor v) {
       return v.visit(this);
    }

    @Override
    public boolean getLogicalValue() {
        return this.getLeftBranch().getLogicalValue() && this.getRightBranch().getLogicalValue();
    }
}
