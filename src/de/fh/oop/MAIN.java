package de.fh.oop;

import de.fh.oop.treenodes.Expression;
import de.fh.oop.util.Parser;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.VisitorAusgabe;

import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        System.out.println("Bitte einen Bool'schen Ausdruck eingeben (mit Leerzeichen trennen, außer bei Klammern): ");
        String inputScanner = new Scanner(System.in).nextLine();
        Expression myExpression = Parser.parseString(inputScanner);
        myExpression.print("");
        String code = myExpression.acceptVisitor(new VisitorAusgabe(), null, null);
        System.out.println(code);
        Expression myExpressionCopy = myExpression.copy();
        myExpressionCopy.acceptVisitor(new VisitorAusgabe(), null, null);

//        System.out.println("myExpression.equals(myExpressionCopy): " + myExpression.acceptVisitor(new Visitor4Equals(), myExpressionCopy));

    }
}
