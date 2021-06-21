package de.fh.oop;

import de.fh.oop.treenodes.*;
import de.fh.oop.util.*;
import de.fh.oop.util.visitor.*;

import java.util.Scanner;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        System.out.println("Bitte einen Bool'schen Ausdruck eingeben (mit Leerzeichen trennen, auch bei Klammern): ");

        String inputScanner = new Scanner(System.in).nextLine();

        Expression myExpression = Parser.parseString(inputScanner);

        System.out.println("\nDer Term \"" + ANSI_GREEN + inputScanner + ANSI_RESET + "\" hat den logischen Wert \"" + ANSI_GREEN + myExpression.getLogicalValue() + ANSI_RESET +  "\"" );
        System.out.println("Der Baum dazu sieht wie folgt aus:");
        myExpression.print("");
        System.out.println("Der Code zur Instanziierung diese Baumes lautet: " + ANSI_YELLOW + myExpression.acceptVisitor(new VisitorAusgabe(), null, null) + ANSI_RESET);


        System.out.println("\nCopying...\n");
        Expression myExpressionCopy = myExpression.copy();
        System.out.println("Die Instanz " + ANSI_PURPLE + myExpression + ANSI_RESET + " wurde kopiert und als neue Instanz " + ANSI_PURPLE + myExpressionCopy + ANSI_RESET + " angelegt");

        System.out.println("Logischer Wert der Kopie: " + ANSI_GREEN + myExpressionCopy.getLogicalValue() + ANSI_RESET);
        System.out.println("Code der Kopie: " + ANSI_YELLOW + myExpressionCopy.acceptVisitor(new VisitorAusgabe(), null, null) + ANSI_RESET);
        System.out.println("Baum der Kopie:");
        myExpression.print("");
//        System.out.println("myExpression.equals(myExpressionCopy): " + myExpression.acceptVisitor(new Visitor4Equals(), myExpressionCopy));
    }
}
