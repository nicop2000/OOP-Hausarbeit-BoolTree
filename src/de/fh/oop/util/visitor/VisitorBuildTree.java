package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

import java.util.List;

public class VisitorBuildTree implements Visitor4Tree {

    private static VisitorBuildTree instance = null;
    public synchronized static VisitorBuildTree getInstance() {
        if (instance == null) {
            instance = new VisitorBuildTree();
        }
        return instance;
    }
    private VisitorBuildTree() {}


    public Integer visit(AndExpression and, List<Expression> myExpressions, int i) {
        and.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
        myExpressions.remove(i + 1);
        myExpressions.remove(i - 1);
        return --i;
    }
    public Integer visit(OrExpression or, List<Expression> myExpressions, int i) {
        or.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
        myExpressions.remove(i + 1);
        myExpressions.remove(i - 1);
        return --i;
    }
    public Integer visit(XorExpression xorExpression, List<Expression> myExpressions, int i) {
        xorExpression.setLeftBranch(myExpressions.get(i - 1)).setRightBranch(myExpressions.get(i + 1));
        myExpressions.remove(i + 1);
        myExpressions.remove(i - 1);
        return --i;
    }

    public Integer visit(NotExpression notExpression, List<Expression> myExpressions, int i) {
        return i;
    }

    public Integer visit(Expression a, List<Expression> myExpressions, int i) {
        return i;
    }

}
