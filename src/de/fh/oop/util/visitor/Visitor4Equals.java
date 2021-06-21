package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.XorExpression;
import de.fh.oop.treenodes.*;

public class Visitor4Equals {


    public Boolean visit(OrExpression or1) {
        return false;
    }
    public Boolean visit(XorExpression xorExpression1) {
        return false;
    }
    public Boolean visit(NotExpression notExpression1){
        return false;
    }
    public Boolean visit(Value value1) {
        return false;
    }

    public Boolean visit(AndExpression and1, AndExpression and2) {
        return true;
    }

    public Boolean visit(AndExpression a, Expression a2) {
//        a.equalStructure(new Visitor4Equals(), a2.cast(new Visitor4Casting()));
        this.visit(a, a2.cast(new Visitor4Casting()));
        return true;
    }




}
