package de.fhkiel.main;

public class OrAssertion extends BinaryAssertion {

    OrAssertion(Assertion left, Assertion right) {
        super(left, right);
    }

    @Override
    public void print() {
        System.out.print("OR EXPR");
        this.getLeftBranch().print();
        System.out.print("||");
        this.getRightBranch().print();
    }

    @Override
    public boolean getLogicalValue() {
        return this.getLeftBranch().getLogicalValue() || this.getRightBranch().getLogicalValue();
    }
}
