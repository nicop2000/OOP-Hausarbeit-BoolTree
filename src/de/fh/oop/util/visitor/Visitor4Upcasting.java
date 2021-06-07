package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

public class Visitor4Upcasting {

    private static Visitor4Upcasting instance = null;
    public synchronized static Visitor4Upcasting getInstance() {
        if (instance == null) {
            instance = new Visitor4Upcasting();
        }
        return instance;
    }
    private Visitor4Upcasting() {}

    public AndExpression visit(AndExpression and) {
        return and;
    }
    public OrExpression visit(OrExpression or) {
        return or;
    }
    public XorExpression visit(XorExpression xor) {
        return xor;
    }
    public NotExpression visit(NotExpression not) {
        return not;
    }
    public Value visit(Value val) {
        return val;
    }

}
