package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.XorExpression;
import de.fh.oop.treenodes.*;

import java.util.List;

public class VisitorBuildAnd implements Visitor4Tree<Integer, List<Expression>, Integer> {


    /**
     * nimmt Liste der Ausdrücke und Index entgegen und fügt dem Und-Operator mit den entsprechenden Ausdrücken zusammen und
     * entfernt diese anschließend aus der Liste. Gibt i - 1 zurück, da die Liste um ein verkürzt wurde und sonst
     * nicht alle Elemente bahndelt würden
     */
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
    /*
     * Die restlichen Ausdrücke werden vorerst nicht bearbeitet (bzw. Nicht wurde schon bearbeitet) und geben nur i zurück, um den nächsten Schleifendurch-
     * lauf zu initiieren
     */

    @Override
    public Integer visit(final OrExpression or, final List<Expression> myExpressions, final Integer i) {
        return i;
    }

    @Override
    public Integer visit(final XorExpression xorExpression, final List<Expression> myExpressions, final Integer i) {
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
        throw new IllegalArgumentException("--Error occured-- --Found Expression in VisitorBuildAnd--");
    }



}
