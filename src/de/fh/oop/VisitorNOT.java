package de.fh.oop;

import java.util.List;

public class VisitorNOT implements Visitor {

    public Integer visit(Assertion a, List<Assertion> myAssertions, int i) {
        return i;
    }

    public Integer visit(AndAssertion and, List<Assertion> myAssertions, int i) {
        return i;
    }
    public Integer visit(OrAssertion or, List<Assertion> myAssertions, int i) {
        return i;
    }
    public Integer visit(XOR xor, List<Assertion> myAssertions, int i) {
        return i;
    }

    public Integer visit(NOT not, List<Assertion> myAssertions, int i) {
        not.setMyNOTAssertion(myAssertions.get(i + 1));
        myAssertions.remove(i + 1);
        return i;
    }
}