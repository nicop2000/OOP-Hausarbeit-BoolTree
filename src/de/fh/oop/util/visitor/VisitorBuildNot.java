package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

import java.util.List;

public class VisitorBuildNot implements Visitor4Tree<Integer, List<Expression>, Integer> {

    /**
     * nimmt Liste der Ausdrücke und Index entgegen und verändert fügt den Nicht-Operator mit dem entsprechenden Ausdruck zusammen und
     * entfernt diesen anschließend aus der Liste
     */
    public Integer visit(final NotExpression notExpression, final List<Expression> myExpressions, final Integer i) {
        if (notExpression.getMyNotAssertion() == null) {
            notExpression.setMyNotAssertion(myExpressions.get(i + 1));
            myExpressions.remove(i + 1);
        }
        return i;
    }

    /*
     * Die restlichen Ausdrücke werden vorerst nicht bearbeitet  und geben nur i zurück, um den nächsten Schleifendurch-
     * lauf zu initiieren
     */
    public Integer visit(final Expression a, final List<Expression> myExpressions, final Integer i) {
        throw new IllegalArgumentException("--Error occured-- --Found Expression in VisitorBuildNot--");
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


    public Integer visit(final Value val, final List<Expression> expressions, final Integer i) {
        return i;
    }
}
