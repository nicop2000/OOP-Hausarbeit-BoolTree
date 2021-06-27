package de.fh.oop;

import de.fh.oop.treenodes.*;
import de.fh.oop.util.*;
import de.fh.oop.util.visitor.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bitte einen Bool'schen Ausdruck eingeben (mit Leerzeichen trennen, auch bei Klammern): ");

        String inputScanner = new Scanner(System.in).nextLine();

        Expression myExpression = Parser.getINSTANCE().parseString(inputScanner);

        System.out.println("\nDer Term \"" + inputScanner +"\" hat den logischen Wert \"" + myExpression.getLogicalValue() + "\"" );
        System.out.println("Der Baum dazu sieht wie folgt aus:");
        System.out.println(myExpression.print(""));
        System.out.println("Der Code zur Instanziierung diese Baumes lautet: " + myExpression.acceptVisitor(new VisitorCodeausgabe(), null, null));


        System.out.println("\nCopying...\n");
        Expression myExpressionCopy = myExpression.copy();
        System.out.println("Die Instanz " + myExpression + " wurde kopiert und als neue Instanz " + myExpressionCopy + " angelegt");

        System.out.println("Logischer Wert der Kopie: " + myExpressionCopy.getLogicalValue());
        System.out.println("Code der Kopie: " + myExpressionCopy.acceptVisitor(new VisitorCodeausgabe(), null, null));
        System.out.println("Baum der Kopie:");
        System.out.println(myExpression.print(""));

        System.out.println("\nBitte einen weiteren Bool'schen Ausdruck zum Vergleich mit dem Vorherigen eingeben (mit Leerzeichen trennen, auch bei Klammern): ");
        String inputScanner2 = new Scanner(System.in).nextLine();
        Expression myExpression2 = Parser.getINSTANCE().parseString(inputScanner2);
        System.out.println("Der Baum dazu sieht wie folgt aus:");
        System.out.println(myExpression2.print(""));
        System.out.println("Der Code zur Instanziierung diese Baumes lautet: " + myExpression2.acceptVisitor(new VisitorCodeausgabe(), null, null));

        System.out.println("Sind beide Bäume inhaltlich gleich? " + myExpression.equalContent(myExpression2));

        System.out.println("Sind beide Bäume strukturell gleich? " + myExpression.equalStructure(myExpression2));


//        System.out.println("myExpression.equals(myExpressionCopy): " + myExpression.acceptVisitor(new Visitor4Equals(), myExpressionCopy));
    }
}
