package de.fh.oop;

import java.util.List;

public interface Assertion {



    boolean getLogicalValue();

    void print(String einrueckung);

    Integer acceptVisitor(Visitor v, List<Assertion> myAssertion, int i);

    void codeausgabe(VisitorAusgabe v);

    int size();




}
