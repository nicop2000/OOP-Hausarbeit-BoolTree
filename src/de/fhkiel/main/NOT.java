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
    public String acceptVisitor(Visitor v) {
        return v.visit(this);
    }

    @Override
    public void codeausgabe(VisitorAusgabe v) {
        v.codeausgabe(this);
    }

    @Override
    public int size() {
        int d = getMyNOTAssertion().size() + 1;
        return d;
    }

    @Override
    public void print(String einrueckung) {
        System.out.print(einrueckung + "  "+ "–");
        getMyNOTAssertion().print(einrueckung + "  ");

    }

}
