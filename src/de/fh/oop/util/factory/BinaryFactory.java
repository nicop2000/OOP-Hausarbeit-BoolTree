package de.fh.oop.util.factory;

import de.fh.oop.treenodes.AndExpression;
import de.fh.oop.treenodes.Expression;
import de.fh.oop.treenodes.OrExpression;
import de.fh.oop.treenodes.XorExpression;

public enum BinaryFactory {
    AND {
        @Override
        public Expression create(Expression leftBranch, Expression rightBranch) {
            return new AndExpression(leftBranch, rightBranch);
        }
    },
    OR {
        @Override
        public Expression create(Expression leftBranch, Expression rightBranch) {
            return new OrExpression(leftBranch, rightBranch);
        }
    },
    XOR {
        @Override
        public Expression create(Expression leftBranch, Expression rightBranch) {
            return new XorExpression(leftBranch, rightBranch);
        }
    };

    public abstract Expression create(Expression leftBranch, Expression rightBranch);
}
