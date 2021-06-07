package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.AndExpression;

public class Visitor4Calc<A> {

    private static Visitor4Calc instance = null;
    public synchronized static Visitor4Calc getInstance() {
        if (instance == null) {
            instance = new Visitor4Calc();
        }
        return instance;
    }
    private Visitor4Calc() {}

//    public A visit(AndExpression andExpression) {
//        return A;
//    }
}
