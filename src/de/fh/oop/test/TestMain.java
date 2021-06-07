package de.fh.oop.test;

import de.fh.oop.treenodes.AndExpression;
import de.fh.oop.treenodes.Expression;
import de.fh.oop.treenodes.OrExpression;
import de.fh.oop.treenodes.Value;
import de.fh.oop.util.Parser;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.VisitorAusgabe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMain {

    @Test
    void main() {
        Expression myExpression = new AndExpression(new Value(true), new OrExpression(new Value(false), new AndExpression(new Value(true), new Value(false))));

        assertEquals(Parser.parseString("true && ( false || ( true && false ) )").codeausgabe(VisitorAusgabe.getInstance()), "new AndExpression(new Value(true), new OrExpression(new Value(false), new AndExpression(new Value(true), new Value(false))))");

        Expression testung = new OrExpression(new Value(true), new Value(false));
        Expression testung2 = testung.copy();
//        testung.acceptVisitor(new Visitor4Equals(), testung2);
        Expression eins = Parser.parseString("true && ( false || true )");
        Expression zwei = Parser.parseString("( true || false ) && true");
        assertTrue(eins.equalContent(zwei));
    }
}
