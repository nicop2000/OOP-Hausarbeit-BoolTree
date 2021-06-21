package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.XorExpression;
import de.fh.oop.treenodes.*;

import java.util.List;

public class VisitorBuildRest implements Visitor4Tree<Integer, List<Expression>, Integer> {

    @Override
    public Integer visit(final AndExpression and, final List<Expression> myExpressions, final Integer i) {
        if (and.getLeftBranch() == null && and.getRightBranch() == null) {
            and.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
            myExpressions.remove(i + 1);
            myExpressions.remove(i - 1);
            return i - 1;
        }
        return i;
    }

    @Override
    public Integer visit(final OrExpression or, final List<Expression> myExpressions, final Integer i) {
        if (or.getLeftBranch() == null && or.getRightBranch() == null) {
            or.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
            myExpressions.remove(i + 1);
            myExpressions.remove(i - 1);
            return i - 1;
        }
        return i;
    }
    @Override
    public Integer visit(final XorExpression xor, final List<Expression> myExpressions, final Integer i) {
        if (xor.getLeftBranch() == null && xor.getRightBranch() == null) {
            xor.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
            myExpressions.remove(i + 1);
            myExpressions.remove(i - 1);
            return i - 1;
        }
        return i;
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
