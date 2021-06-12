package de.fh.oop.treenodes;

public abstract class BinaryExpression implements Expression {

    private Expression rightBranch = null;
    private Expression leftBranch = null;


    BinaryExpression(final Expression left, final Expression right) {
        this.setLeftBranch(left).setRightBranch(right);
    }

    public Expression getRightBranch() {
        return rightBranch;
    }

    public BinaryExpression setRightBranch(final Expression rightBranch) {
        this.rightBranch = rightBranch;
        return this;
    }

    public Expression getLeftBranch() {
        return leftBranch;
    }

    public BinaryExpression setLeftBranch(final Expression leftBranch) {
        this.leftBranch = leftBranch;
        return this;
    }
}
