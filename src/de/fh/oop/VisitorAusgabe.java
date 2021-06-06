package de.fh.oop;

public class VisitorAusgabe {

    public void codeausgabe(AndAssertion and) {
        System.out.print("new AndAssertion(");
        and.getLeftBranch().codeausgabe(new VisitorAusgabe());
        System.out.print(", ");
        and.getRightBranch().codeausgabe(new VisitorAusgabe());
        System.out.print(")");

    }
    public void codeausgabe(OrAssertion or) {
        System.out.print("new OrAssertion(");
        or.getLeftBranch().codeausgabe(new VisitorAusgabe());
        System.out.print(", ");
        or.getRightBranch().codeausgabe(new VisitorAusgabe());
        System.out.print(")");
    }
    public void codeausgabe(XOR xor) {
        System.out.print("new XOR(");
        xor.getLeftBranch().codeausgabe(new VisitorAusgabe());
        System.out.print(", ");
        xor.getRightBranch().codeausgabe(new VisitorAusgabe());
        System.out.print(")");
    }
    public void codeausgabe(NOT not) {
        System.out.print("new NOT(");
        not.getMyNOTAssertion().codeausgabe(new VisitorAusgabe());
        System.out.print(")");
    }

    public void codeausgabe(Value val) {
        System.out.print("new Value(" + val.getLogicalValue() + ")");

    }



}
