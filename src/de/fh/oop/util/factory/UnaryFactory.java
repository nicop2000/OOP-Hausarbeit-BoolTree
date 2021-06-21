package de.fh.oop.util.factory;

import de.fh.oop.treenodes.Expression;
import de.fh.oop.treenodes.NotExpression;

public enum UnaryFactory{
    NOT {
        @Override
        public NotExpression create(final Expression expression) {
            return new NotExpression(expression);
        }
    };

    public abstract Expression create(final Expression expression);
}
