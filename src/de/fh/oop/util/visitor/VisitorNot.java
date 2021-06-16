package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

import java.io.IOException;
import java.util.List;

public class VisitorNot implements Visitor4Tree<Integer, List<Expression>, Integer> {

    public Integer visit(final Expression a, final List<Expression> myExpressions, final Integer i) {
        return i;
    }

    public Integer visit(final AndExpression and, final List<Expression> myExpressions, final Integer i) {
        return i;
    }
    public Integer visit(final OrExpression or, final List<Expression> myExpressions, final Integer i) {
        return i;
    }
    public Integer visit(final XorExpression xorExpression, final List<Expression> myExpressions, final Integer i) {
        return i;
    }

    public Integer visit(final NotExpression notExpression, final List<Expression> myExpressions, final Integer i) {
        notExpression.setMyNOTAssertion(myExpressions.get(i + 1));
        myExpressions.remove(i + 1);
        return i;
    }

    @Override
    public Integer visit(final Value val, final List<Expression> expressions, final Integer i) {
        return i;
    }
}
