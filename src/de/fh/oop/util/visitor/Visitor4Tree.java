package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

import java.util.List;

public interface Visitor4Tree {

    Integer visit(Expression a, List<Expression> myExpressions, int i);
    Integer visit(AndExpression and, List<Expression> myExpressions, int i);
    Integer visit(OrExpression or, List<Expression> myExpressions, int i);
    Integer visit(XorExpression xorExpression, List<Expression> myExpressions, int i);
    Integer visit(NotExpression notExpression, List<Expression> myExpressions, int i);



}