package de.fh.oop.treenodes;

import de.fh.oop.util.factory.BinaryFactory;
import de.fh.oop.util.visitor.Visitor4Tree;

public class XorExpression extends BinaryExpression {

    private final Type type = Type.XOR;

    public Type getType() {
        return type;
    }

    public XorExpression(final Expression left, final Expression right) {
        super(left, right);
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
        return BinaryFactory.XOR.create(this.getLeftBranch().copy(), this.getRightBranch().copy());
    }

    /*
     * gibt den Bool'schen Wert des Ausdrucks zurück
     */
    @Override
    public boolean getLogicalValue() {
        return getLeftBranch().getLogicalValue() ^ getRightBranch().getLogicalValue();
    }

    /*
     * erstellt eine Stringausgabe des Baumes
     */
    @Override
    public String print(final String indent) {
        return indent + "^\n" + this.getLeftBranch().print(indent + " ") + "\n" + this.getRightBranch().print(indent + " ");
    }

    /*
     * prüft, ob ein Knoten, inklusive Kinder, einem anderen exakt gleicht
     */
    @Override
    public boolean equalStructure(final Expression expression) {
        if (!(this.getType() == expression.getType())) {
            return false;
        }
        return getLeftBranch().equalStructure(((XorExpression) expression).getLeftBranch()) && getRightBranch().equalStructure(((XorExpression) expression).getRightBranch());

    }



    /*
     * gitb die Anzahl der Knoten des Teilbaums zurück, von dem 'this' der Knoten ist
     */
    @Override
    public int size() {
        return getLeftBranch().size() + getRightBranch().size() + 1;
    }

}
