package de.fh.oop;

import java.util.List;

public interface Visitor {

    Integer visit(Assertion a, List<Assertion> myAssertions, int i);
    Integer visit(AndAssertion and, List<Assertion> myAssertions, int i);
    Integer visit(OrAssertion or, List<Assertion> myAssertions, int i);
    Integer visit(XOR xor, List<Assertion> myAssertions, int i);
    Integer visit(NOT not, List<Assertion> myAssertions, int i);
}