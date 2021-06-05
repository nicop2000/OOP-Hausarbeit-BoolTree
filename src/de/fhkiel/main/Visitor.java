package de.fhkiel.main;

public class Visitor {

    public String visit(Assertion a) {
return "general";
    }
    public String visit(AndAssertion and){
return "and";
    }
    public String visit(OrAssertion or) {
return "or";
    }
    public String visit(XOR xor) {
return "xor";
    }
    public String visit(NOT not) { return "not"; }

}
