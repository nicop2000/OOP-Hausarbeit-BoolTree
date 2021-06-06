package de.fh.oop;

import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Bitte einen Bool'schen Ausdruck eingeben (mit Leerzeichen trennen, außer bei Klammern): ");
        String eingabeScanner = new Scanner(System.in).nextLine();

        String eingabe = "true && false && true || ( true && ( false || false ) ^ false )";
        String eingabe2 = "true && NOT false && true || ( true && ( false || false ) ^ false )";
        String eingabe3 = "NOT ( true && NOT false && true || ( true && ( false || false ) ^ false ) )";
        String forPrint = "true && false || false";
        Assertion myAssertionn = new AndAssertion(new Value(true), new OrAssertion(new Value(false), new AndAssertion(new Value(true), new Value(false))));

        Assertion myAsserionnCode = new AndAssertion(new Value(true), new OrAssertion(new Value(false), new AndAssertion(new Value(true), new Value(false))));

//        System.out.println(eingabe);

        Assertion myAssertion = ParserNeu.parseString(eingabeScanner);

        Assertion forPrinting = ParserNeu.parseString(forPrint);
        myAssertion.print("");


    }
}
