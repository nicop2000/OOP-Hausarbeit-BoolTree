package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

public class Visitor4Equals {

    private static Visitor4Equals instance = null;


    public Boolean visit(AndExpression and1, AndExpression and2) {
        return true;
    }
    public Boolean visit(OrExpression or1, OrExpression or2) {
        return true;
    }
    public Boolean visit(XorExpression xorExpression1, XorExpression xorExpression2) {
        return true;
    }
    public Boolean visit(NotExpression notExpression1, NotExpression notExpression){
        return true;
    }
    public Boolean visit(Value value1, Value value2) {
        return value1 == value2;
    }

    public Boolean visit(Expression a, Expression a2) {return false;}




}
