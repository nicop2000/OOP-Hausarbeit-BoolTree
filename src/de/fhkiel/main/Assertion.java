package de.fhkiel.main;

public interface Assertion {



    boolean getLogicalValue();

    void print(String einrueckung);

    String acceptVisitor(Visitor v);

    void codeausgabe(VisitorAusgabe v);

    int size();




}
