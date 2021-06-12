package de.fh.oop.test;

import de.fh.oop.treenodes.AndExpression;
import de.fh.oop.treenodes.Expression;
import de.fh.oop.treenodes.OrExpression;
import de.fh.oop.treenodes.Value;
import de.fh.oop.util.Parser;
import de.fh.oop.util.visitor.Visitor4Casting;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.VisitorAusgabe;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestMain {

    @Test
    void parse() {
        Expression eins = Parser.parseString("true && ( false || true )");
        Expression zwei = Parser.parseString("( true || false ) && true");
        Expression drei = Parser.parseString("false && false && false && false || true )");
        Expression vier = Parser.parseString("true && true && true");
        assertTrue(eins.equalContent(zwei));
        assertTrue(drei.equalContent(vier));
    }

    @Test
    void codeausgabe() {
        assertEquals(Parser.parseString("true && ( false || ( true && false ) )")
                        .acceptVisitor(new VisitorAusgabe(), null, null),
                "new AndExpression(new Value(true), new OrExpression(new Value(false), " +
                        "new AndExpression(new Value(true), new Value(false))))");
    }

    @Test
    void print() {
        Expression myExp = new AndExpression(new OrExpression(new Value (true), new Value(false)), new Value(true));
        // PrintStream für Speicherung von System.out.println erstellen
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        // Standard Zeil von System.out.println zwischenspeichern
        PrintStream old = System.out;
        // System.out.println auf eigenen PrintStream umleiten
        System.setOut(printStream);
        myExp.print("");
        // System.out leeren und wieder auf Standard zurücksetzen
        System.out.flush();
        System.setOut(old);
        assertEquals("&&\n ||\n  true\n  false\n true\n", byteArrayOutputStream.toString());
    }

    @Test
    void equalStructure() {
        Expression myExp = new AndExpression(new Value(true), new Value(false));
        Expression myExp2 = new AndExpression(new Value(true), new Value(false));
        assertTrue(myExp.equalStructure(new Visitor4Equals(), myExp2));
    }

    @Test
    void equalContent() {
        Expression myExp = new AndExpression(new Value(true), new Value(true));
        Expression myExp2 = new OrExpression(new Value(false), new Value(true));
        assertTrue(myExp.equalContent(myExp2));
    }

    @Test
    void copy() {

        Expression original = new OrExpression(new AndExpression(new AndExpression(new AndExpression(new Value(false),
                new Value(false)), new Value(false)), new Value(false)), new Value(true));

        Expression copy = original.copy();

        equalThree(original, copy);
    }


    void equalThree(Expression ex1, Expression ex2) {
        assertEquals(ex1.acceptVisitor(new VisitorAusgabe(), null, null), ex2.acceptVisitor(new VisitorAusgabe(), null, null));
        assertTrue(ex2.equalContent(ex1));
        assertTrue(ex1.equalStructure(new Visitor4Equals(), ex2));

    }
}
