package de.fhkiel.main;

public abstract class BinaryAssertion implements Assertion {

    private Assertion rightBranch = null;
    private Assertion leftBranch = null;

    BinaryAssertion(final Assertion left, final Assertion right) {
        this.setLeftBranch(left).setRightBranch(right);
    }

    public Assertion getRightBranch() {
        return rightBranch;
    }

    public BinaryAssertion setRightBranch(Assertion rightBranch) {
        this.rightBranch = rightBranch;
        return this;
    }

    public Assertion getLeftBranch() {
        return leftBranch;
    }

    public BinaryAssertion setLeftBranch(Assertion leftBranch) {
        this.leftBranch = leftBranch;
        return this;
    }
}
