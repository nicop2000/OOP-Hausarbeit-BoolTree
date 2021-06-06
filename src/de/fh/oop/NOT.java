package de.fh.oop;

import java.util.List;

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
    public Integer acceptVisitor(Visitor v, List<Assertion> myAssertions, int i) {
        return v.visit(this, myAssertions, i);
    }

    @Override
    public void codeausgabe(VisitorAusgabe v) {
        v.codeausgabe(this);
    }

    @Override
    public int size() {
        return getMyNOTAssertion().size() + 1;

    }

    @Override
    public void print(String einrueckung) {
        System.out.print(einrueckung + "  "+ "–");
        getMyNOTAssertion().print(einrueckung + "  ");

    }

}
