package de.fhkiel.main;

public class NOT implements Assertion{
    private Assertion myNOTAssertion = null;

//    NOT() {
//
//    }

    public NOT(final Assertion notAssertion) {
        setMyNOTAssertion(notAssertion);

    }

    protected NOT setMyNOTAssertion(final Assertion notAssertion) {
        myNOTAssertion = notAssertion;
        return this;
    }

    public Assertion getMyNOTAssertion() {
        return myNOTAssertion;
    }

    @Override
    public boolean getLogicalValue() {
        return !getMyNOTAssertion().getLogicalValue();
    }

    @Override
    public void print() {
        System.out.print("–");
        System.out.print(getMyNOTAssertion().getLogicalValue());

    }
}
