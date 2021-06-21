package de.fh.oop.util.factory;

import de.fh.oop.treenodes.Expression;
import de.fh.oop.treenodes.Value;

public enum ValueFactory {
    VALUE {
        @Override
        public Value create(final Boolean value) {
            return new Value(value);
        }
    };

    public abstract Expression create(final Boolean value);
}
