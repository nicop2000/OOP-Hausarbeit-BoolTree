package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

import java.util.List;

public class VisitorNot implements Visitor4Tree {

    private static VisitorNot instance = null;
    public synchronized static VisitorNot getInstance() {
        if (instance == null) {
            instance = new VisitorNot();
        }
        return instance;
    }
    private VisitorNot() {}

    public Integer visit(Expression a, List<Expression> myExpressions, int i) {
        return i;
    }

    public Integer visit(AndExpression and, List<Expression> myExpressions, int i) {
        return i;
    }
    public Integer visit(OrExpression or, List<Expression> myExpressions, int i) {
        return i;
    }
    public Integer visit(XorExpression xorExpression, List<Expression> myExpressions, int i) {
        return i;
    }

    public Integer visit(NotExpression notExpression, List<Expression> myExpressions, int i) {
        notExpression.setMyNOTAssertion(myExpressions.get(i + 1));
        myExpressions.remove(i + 1);
        return i;
    }
}
