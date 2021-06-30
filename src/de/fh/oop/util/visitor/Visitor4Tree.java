package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

/*
 * Generisches Interface für alle Visitoren. Wird gebraucht, damit alle Visitoren über die acceptVisitor-Methode
 * entgegengenommen werden können
 */

public interface Visitor4Tree<R, B ,C> {

    R visit(final Expression a, final B myExpressions, final C i);
    R visit(final AndExpression and, final B myExpressions, final C i);
    R visit(final OrExpression or, final B myExpressions, final C i);
    R visit(final XorExpression xorExpression, final B myExpressions, final C i);
    R visit(final NotExpression notExpression, final B myExpressions, final C i);
    R visit(final Value val, final B b, C c);



}