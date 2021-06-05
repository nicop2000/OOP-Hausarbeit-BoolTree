package de.fhkiel.main;

public class VisitorAusgabe {

    public void codeausgabe(AndAssertion and) {
        System.out.println("new AndAssertion(");

    }
    public void codeausgabe(OrAssertion or) {
        System.out.println("new OrAssertion(");
    }
    public void codeausgabe(XOR xor) {
        System.out.println("new XOR(");
    }
    public void codeausgabe(NOT not) {
        System.out.println("new NOT(");
    }

    public void codeausgabe(Value val) {
        System.out.println("new Value(");
    }



}
