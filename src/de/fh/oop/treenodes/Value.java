package de.fh.oop.treenodes;

import de.fh.oop.util.factory.ValueFactory;
import de.fh.oop.util.visitor.Visitor4Tree;

public class Value implements Expression {

    private final Type type = Type.VALUE;

    public Type getType() {
        return type;
    }

    private boolean value = false;

    public Value(final boolean value) {
        setValue(value);
    }

    private Value setValue(final boolean value) {
        this.value = value;
        return this;
    }

    public boolean getValue() {
        return value;
    }

    /**
     * nimmt generischen Visitor entgegen <Rückgabetyp, Parameter 2, Parameter 3>
     */
    @Override
    public <R, B, C> R acceptVisitor(final Visitor4Tree<R, B, C> visitor, final B b, final C c) {
        return visitor.visit(this, b, c);
    }

    /*
     * erstellt eine exakte Kopie der Instanz
     */
    @Override
    public Expression copy() {
        return ValueFactory.VALUE.create(getLogicalValue());
    }

    /*
     * gibt den Bool'schen Wert des Ausdrucks zurück
     */
    @Override
    public boolean getLogicalValue() {
        return getValue();
    }

    /*
     * erstellt eine Stringausgabe des Baumes
     */
    @Override
    public String print(final String indent) {
        return indent + getLogicalValue();
    }

    /*
     * gitb die Anzahl der Knoten des Teilbaums zurück, von dem 'this' der Knoten ist
     */
    @Override
    public boolean equalStructure(final Expression expression) {
        return this.getLogicalValue() == expression.getLogicalValue();
    }


    /*
     * ist der unterste Knoten eines Teilbaums und gibt immer 1 zurück, da unter ihm nichts mehr kommen kann
     */
    @Override
    public int size() {
        return 1;
    }



}
