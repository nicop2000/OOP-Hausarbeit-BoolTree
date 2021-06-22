package de.fh.oop.treenodes;

import de.fh.oop.util.visitor.Visitor4Casting;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Tree;

public interface Expression {

    boolean getLogicalValue();

    Expression copy();

    boolean equalStructure(final Visitor4Equals v, final Expression expression);

    default boolean equalContent(final Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    };

    Boolean equal(final Visitor4Equals v, final Expression exp);


    Expression cast(final Visitor4Casting v);


    void print(final String einrueckung);

    <R, B, C> R acceptVisitor(final Visitor4Tree<R, B, C> v, final B myExpression, final C i);


//    String codeausgabe(VisitorAusgabe v);

    int size();




}
