package de.fhkiel.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Bitte einen Bool'schen Ausdruck eingeben (mit Leerzeichen trennen, außer bei Klammern): ");
        //String eingabe = myScanner.nextLine();
//        String eingabe = "true || False && True ^ False";
        String eingabe = "true && false && true || ( true && ( false || false ) ^ false )";
        String eingabe2 = "true && NOT false && true || ( true && ( false || false ) ^ false )";
        String eingabe3 = "NOT ( true && NOT false && true || ( true && ( false || false ) ^ false ) )";
        String forPrint = "true && false || false";
        Assertion myAssertionn = new AndAssertion(new Value(true), new OrAssertion(new Value(false), new AndAssertion(new Value(true), new Value(false))));
//        myAssertionn.codeausgabe(new VisitorAusgabe());

//        System.out.println(eingabe);

        Assertion myAssertion = ParserNeu.parseString(eingabe);

        System.out.println("");
//        myAssertion.print();
        System.out.println("");
//        System.out.println("\n" + myAssertion.getLogicalValue());

        System.out.println("\n\n");

//        Assertion myAssertion2 = ParserNeu.parseString(eingabe2);
//        Assertion myAssertion3 = ParserNeu.parseString(eingabe3);
myAssertion.print("");
//        System.out.println("Größe: " + myAssertion2.size());
//        System.out.println("Größe: " + myAssertion3.size());
//        StringBuilder sbLeft = new StringBuilder();
//        for (int i = 0; i < myAssertion2.size(); i++) sbLeft.append(" ");
//        myAssertion2.print(sbLeft.toString());
//        myAssertion2.print("");

        System.out.println("");
//        System.out.println("\n" + myAssertion2.getLogicalValue());

        System.out.println("");
//        myAssertion3.print("");
        System.out.println("");
//        System.out.println("\n" + myAssertion3.getLogicalValue());

        Assertion forPrinting = ParserNeu.parseString(forPrint);
        forPrinting.print(" ");


    }


    public void a() {
        XOR xor = new XOR(new Value(true), new Value(false));
        System.out.println("XOR: " + xor.getLogicalValue());
        Assertion myAssertion = new AndAssertion(new Value(true), new OrAssertion(new Value(false), new AndAssertion(new Value(true), new Value(false))));
        Assertion myAssertion2 = new AndAssertion(new Value(true), new OrAssertion(new Value(false), new AndAssertion(new Value(true), new NOT(new Value(false)))));


        System.out.println();
        System.out.println(myAssertion.getLogicalValue());
        myAssertion2.print("");
        System.out.println();
        System.out.println(myAssertion2.getLogicalValue());

        String myBoolExpression = "true && false || true || –false && true";

        /*
        if ("true") new Value(true)
        if ("&&") new AndAssertion
         */
    }
}
