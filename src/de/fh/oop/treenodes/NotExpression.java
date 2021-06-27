package de.fh.oop.treenodes;

import de.fh.oop.util.factory.UnaryFactory;
import de.fh.oop.util.visitor.Visitor4Tree;

public class NotExpression implements Expression {

    private final Type type = Type.NOT;

    public Type getType() {
        return type;
    }

    private Expression myNotExpression = null;

    public Expression getMyNotAssertion() {
        return myNotExpression;
    }

    public NotExpression setMyNotAssertion(final Expression notExpression) {
        myNotExpression = notExpression;
        return this;
    }

    public NotExpression(final Expression notExpression) {
        setMyNotAssertion(notExpression);
    }

    /**
     * nimmt generischen Visitor entgegen <Rückgabetyp, Parameter 2, Parameter 3>
     */
    @Override
    public <R, B, C> R acceptVisitor(Visitor4Tree<R, B, C> visitor, B b, C c) {
        return visitor.visit(this, b, c);
    }

    /*
     * erstellt eine exakte Kopie der Instanz
     */
    @Override
    public Expression copy() {
        return UnaryFactory.NOT.create(getMyNotAssertion().copy());
    }

    /*
     * gibt den Bool'schen Wert des Ausdrucks zurück
     */
    @Override
    public boolean getLogicalValue() {
        return !getMyNotAssertion().getLogicalValue();
    }

    /*
     * erstellt eine Stringausgabe des Baumes
     */
    @Override
    public String print(final String indent) {
        return indent + "–" + getMyNotAssertion().print(indent);

    }

    /*
     * prüft, ob ein Knoten, inklusive Kinder, einem anderen exakt gleicht
     */
    @Override
    public boolean equalStructure(final Expression expression) {
        if (!(this.getType() == expression.getType())) {
            return false;
        }
        return getMyNotAssertion().equalStructure(((NotExpression) expression).getMyNotAssertion());
    }

    /*
     * gitb die Anzahl der Knoten des Teilbaums zurück, von dem 'this' der Knoten ist
     */
    @Override
    public int size() {
        return getMyNotAssertion().size() + 1;
    }



}
