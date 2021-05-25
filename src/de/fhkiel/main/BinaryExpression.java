package de.fhkiel.main;

public abstract class BinaryExpression implements Assertion {

    private Assertion rightBranch = null;
    private Assertion leftBranch = null;

    BinaryExpression(final Assertion left, final Assertion right) {
        this.setLeftBranch(left).setRightBranch(right);
    }

    public Assertion getRightBranch() {
        return rightBranch;
    }

    public BinaryExpression setRightBranch(Assertion rightBranch) {
        this.rightBranch = rightBranch;
        return this;
    }

    public Assertion getLeftBranch() {
        return leftBranch;
    }

    public BinaryExpression setLeftBranch(Assertion leftBranch) {
        this.leftBranch = leftBranch;
        return this;
    }
}
