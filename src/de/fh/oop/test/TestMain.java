package de.fh.oop.test;

import de.fh.oop.treenodes.*;
import de.fh.oop.util.visitor.*;
import de.fh.oop.util.Parser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMain {

    @Test
    void parse() {
        Expression eins = Parser.getINSTANCE().parseString("true and ( false or true )");
        Expression zwei = Parser.getINSTANCE().parseString("( true or false ) and true");
        Expression drei = Parser.getINSTANCE().parseString("false and false and false and false or true )");
        Expression vier = Parser.getINSTANCE().parseString("true and true and true");
        assertTrue(eins.equalContent(zwei));
        assertTrue(drei.equalContent(vier));
    }

    @Test
    void codeausgabe() {
        assertEquals(Parser.getINSTANCE().parseString("true and ( false or ( true and false ) )")
                        .acceptVisitor(new VisitorCodeausgabe(), null, null),
                "new AndExpression(new Value(true), new OrExpression(new Value(false), " +
                        "new AndExpression(new Value(true), new Value(false))))");
    }

    @Test
    void print() {
        Expression myExp = new AndExpression(new OrExpression(new Value(true), new Value(false)), new Value(true));
        assertEquals("&&\n ||\n  true\n  false\n true", myExp.print(""));
    }

    @Test
    void equalStructure() {
        Expression myExp = new AndExpression(new Value(true), new Value(false));
        Expression myExp2 = new AndExpression(new Value(true), new Value(false));
        assertTrue(myExp.equalStructure(myExp2));
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
        assertEquals(ex1.acceptVisitor(new VisitorCodeausgabe(), null, null),
                ex2.acceptVisitor(new VisitorCodeausgabe(), null, null));
        assertTrue(ex2.equalContent(ex1));
        assertTrue(ex1.equalStructure(ex2));

    }

    @Test
    void cast() {
        Expression e = new AndExpression(new Value(true), new Value(true));
        Expression e2 = e.copy();
        e.equalStructure(e2);
        System.out.println(e);
        System.out.println(e2);

    }

    @Test
    void parseSomeStrings() {
        assertTrue(Parser.getINSTANCE().parseString("true and ( ( ( false or true ) and true ) or true and false ) or ( " +
                "true and ( false or true ) and not true and true ) and false").getLogicalValue());
        assertFalse(Parser.getINSTANCE().parseString("true xor false and ( ( false and Not true and false or true ) and false or not true ) and not true xor not false").getLogicalValue());
        assertFalse(Parser.getINSTANCE().parseString("( true and ( ( ( false or true ) and true ) or true and false ) or ( true and ( false or true ) and true and true ) and false ) and ( true xor false and ( ( false and Not true and false or true ) and false or not true ) and not true xor not false )").getLogicalValue());
        assertFalse(Parser.getINSTANCE().parseString("not not false").getLogicalValue());
        Parser.getINSTANCE().parseString("false or ( false xor false ) and ( false and true ) and ( true xor true ) or " +
                "false and not false or false xor ( false xor true ) xor ( false and true ) or ( true or false ) or " +
                "true xor true or ( true or true ) xor ( false or false ) or ( true xor true ) or true and not false " +
                "and true or false or not true xor false");
        Expression exp = Parser.getINSTANCE().parseString("false and ( true and true ) or ( false or false ) or ( true " +
                "or true ) xor ( true or false ) or ( false and true ) xor ( true and false ) or ( false or true ) " +
                "and ( false xor true ) and false or not false and false and ( false or true ) and ( true and false )" +
                " and ( false or true ) and ( true and true ) and ( true or true ) xor ( true or true ) or ( false or" +
                " false ) or ( false xor false ) xor false or true or ( true and false ) xor ( true and false ) xor " +
                "( false or false ) or ( false xor true ) and ( true or true ) or ( false xor false ) or ( true and" +
                " true ) xor ( false xor true ) and false or not false or false xor false or false or ( true or false" +
                " ) or ( true xor true ) or ( false and false ) xor ( false xor true ) or ( true xor false ) xor" +
                " ( true xor true ) or ( false or false ) xor ( true and false ) or false or true xor false xor not" +
                " true xor false xor false xor false xor ( false or true ) and ( false or false ) or ( true or false" +
                " ) or ( false or false ) and ( true xor false ) and ( false or false ) or ( true or false ) xor (" +
                " false xor true ) and false or not true and true and true xor not false or false");
        Expression exp2 = Parser.getINSTANCE().parseString("false and ( true and true ) or ( false or false ) or ( true or true ) xor ( true or false ) or ( false and true ) xor ( true and false ) or ( false or true ) and ( false xor true ) and false or not false and false and ( false or true ) and ( true and false ) and ( false or true ) and ( true and true ) and ( true or true ) xor ( true or true ) or ( false or false ) or ( false xor false ) xor false or true or ( true and false ) xor ( true and false ) xor ( false or false ) or ( false xor true ) and ( true or true ) or ( false xor false ) or ( true and true ) xor ( false xor true ) and false or not false or false xor false or false or ( true or false ) or ( true xor true ) or ( false and false ) xor ( false xor true ) or ( true xor false ) xor ( true xor true ) or ( false or false ) xor ( true and false ) or false or true xor false xor not true xor false xor false xor false xor ( false or true ) and ( false or false ) or ( true or false ) or ( false or false ) and ( true xor false ) and ( false or false ) or ( true or false ) xor ( false xor true ) and false or not true and true and true xor not false or false");
        System.out.println(exp2.getLogicalValue());
        System.out.println(exp2.print(""));
        int b = 4;
    }

    @Test
    void catchExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            Parser.getINSTANCE().parseString("true false");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Parser.getINSTANCE().parseString("true and and false");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Parser.getINSTANCE().parseString("true (false");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Parser.getINSTANCE().parseString("true ( false");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Parser.getINSTANCE().parseString("not ture or fals");
        });

    }

    @Test
    void testSth() {
        Expression exp1 = new AndExpression(new Value(true), new Value(true));
        Expression exp2 = new AndExpression(new Value(true), new Value(true));
        System.out.println(exp1.equalStructure(exp2));
    }
}
