package de.fh.oop.util.factory;

import de.fh.oop.treenodes.XorExpression;
import de.fh.oop.treenodes.AndExpression;
import de.fh.oop.treenodes.Expression;
import de.fh.oop.treenodes.OrExpression;

public enum BinaryFactory {
    AND {
        @Override
        public AndExpression create(final Expression leftBranch, final Expression rightBranch) {
            return new AndExpression(leftBranch, rightBranch);
        }
    },
    OR {
        @Override
        public OrExpression create(final Expression leftBranch, final Expression rightBranch) {
            return new OrExpression(leftBranch, rightBranch);
        }
    },
    XOR {
        @Override
        public XorExpression create(final Expression leftBranch, final Expression rightBranch) {
            return new XorExpression(leftBranch, rightBranch);
        }
    };

    public abstract Expression create(final Expression leftBranch, final Expression rightBranch);
}
