package de.fh.oop.treenodes;

import de.fh.oop.util.visitor.Visitor4Tree;

public interface Expression {

    boolean getLogicalValue();

    Expression copy();

    boolean equalStructure(final Expression expression);

    Type getType();

    /*
     * prüft ob ein Baum den gleichen logischen Wert hat, wie ein anderer. Wurde ins Interface ausgelagert,
     * um redundaten Code zu vermeiden
     */
    default boolean equalContent(final Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    };

    String print(final String indent);

    <R, B, C> R acceptVisitor(Visitor4Tree<R, B, C> visitor, B b, C c);

    int size();




}
