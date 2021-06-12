package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

import java.util.List;

public class VisitorBuildTree implements Visitor4Tree<Integer, List<Expression>, Integer> {

    @Override
    public Integer visit(final AndExpression and, final List<Expression> myExpressions, final Integer i) {
        and.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
        myExpressions.remove(i + 1);
        myExpressions.remove(i - 1);
        return i - 1;
    }

    @Override
    public Integer visit(final OrExpression or, final List<Expression> myExpressions, final Integer i) {
        or.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
        myExpressions.remove(i + 1);
        myExpressions.remove(i - 1);
        return i - 1;
    }
    @Override
    public Integer visit(final XorExpression xorExpression, final List<Expression> myExpressions, final Integer i) {
        xorExpression.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
        myExpressions.remove(i + 1);
        myExpressions.remove(i - 1);
        return i - 1;
    }
    @Override
    public Integer visit(final NotExpression notExpression, final List<Expression> myExpressions, final Integer i) {
        return i;
    }

    @Override
    public Integer visit(final Value val, final List<Expression> expressions, final Integer i) {
        return i;
    }

    @Override
    public Integer visit(final Expression a, final List<Expression> myExpressions, final Integer i) {
        return i;
    }

}
