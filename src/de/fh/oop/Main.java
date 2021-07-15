package de.fh.oop;

import de.fh.oop.treenodes.Expression;
import de.fh.oop.util.Parser;
import de.fh.oop.util.visitor.VisitorCodeausgabe;

import java.util.Scanner;

/*
 * Klausurersatzleistung im Fach Objektorientierte Programmierung des Sommersemesters 2021 an der Fachhochschule Kiel

 * Autor: Petersen, Nico
 * Matrikelnummer: 937369
 * Thema: Bool'sche Ausdruecke
 * -----------------------------
 * Was dieses Programm kann
 *  Einen bool'schen Ausdruck ueber die Konsole einlesen
 *   Erlaubte Operatoren:
 *   Staerke der Bindung (absteigend sortiert):
 *     ( )
 *     NOT
 *     AND
 *     OR, XOR
 *  Eine Baumstruktur daraus erstellen und ausgeben
 *  Den Logischen Wert des Ausdrucks ausgeben
 *  Eine Kopie eines Baumes erzeugen
 *  Einen Baum auf strukturelle Gleichheit zu einem anderen Baum pruefen
 *  Einen Baum auf inhaltliche Gleichheit zu einem anderen Baum pruefen
 * -----------------------------
 * Es muss Java Version 14 oder hoeher verwendet werden.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Bitte einen Bool'schen Ausdruck eingeben (mit Leerzeichen trennen, auch bei Klammern): ");

        String inputScanner = new Scanner(System.in).nextLine();

        Expression myExpression = Parser.getInstance().parseString(inputScanner);

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
        Expression myExpression2 = Parser.getInstance().parseString(inputScanner2);
        System.out.println("Der Baum dazu sieht wie folgt aus:");
        System.out.println(myExpression2.print(""));
        System.out.println("Der Code zur Instanziierung diese Baumes lautet: " + myExpression2.acceptVisitor(new VisitorCodeausgabe(), null, null));

        System.out.println("Sind beide Bäume inhaltlich gleich? " + myExpression.equalContent(myExpression2));

        System.out.println("Sind beide Bäume strukturell gleich? " + myExpression.equalStructure(myExpression2));
    }
}
