package de.fhkiel.main;

public class XOR extends BinaryAssertion {

    XOR(Assertion left, Assertion right) {
        super(left, right);
    }

    @Override
    public boolean getLogicalValue() {
        if (getLeftBranch().getLogicalValue() && !getRightBranch().getLogicalValue()) {
            return true;
        }
        return !getLeftBranch().getLogicalValue() && getRightBranch().getLogicalValue();
    }

    @Override
    public void print() {

    }
}
