package de.fh.oop.util.factory;

import de.fh.oop.treenodes.Expression;
import de.fh.oop.treenodes.NotExpression;

public enum UnaryFactory{
    NOT {
        @Override
        public Expression create(Expression expression) {
            return new NotExpression(expression);
        }
    };

    public abstract Expression create(Expression expression);
}
