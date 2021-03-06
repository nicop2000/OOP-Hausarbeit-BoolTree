package de.fh.oop.util;

import de.fh.oop.treenodes.Expression;
import de.fh.oop.util.factory.BinaryFactory;
import de.fh.oop.util.factory.UnaryFactory;
import de.fh.oop.util.factory.ValueFactory;
import de.fh.oop.util.visitor.VisitorBuildAnd;
import de.fh.oop.util.visitor.VisitorBuildNot;
import de.fh.oop.util.visitor.VisitorBuildRest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {

    //Singleton-Pattern
    private static Parser instance = null;
    private Parser() {
    }
    public static synchronized Parser getInstance() {
        if (instance == null) instance = new Parser();
        return instance;
    }

    /*
     * nimmt einen String entgegen und wandelt ihn in einen Baum aus Bool'schen Ausdrücken um
     */
    public Expression parseString(final String expression) {

        if (expression.isEmpty()) throw new IllegalArgumentException("Der eingebene Term ist leer");
        String[] ausdruck = expression.toLowerCase().split(" ");
        List<String> ausdruckListe = new ArrayList<>();
        List<Expression> myExpressions = new ArrayList<>();
        Collections.addAll(ausdruckListe, ausdruck);
        //List mit (teils leeren) Elementen erstellen, werden später verbunden
        for (int i = 0; i < ausdruckListe.size(); i++) {
            switch (ausdruckListe.get(i)) {
                case "and" -> myExpressions.add(BinaryFactory.AND.create(null, null));
                case "or" -> myExpressions.add(BinaryFactory.OR.create(null, null));
                case "xor" -> myExpressions.add(BinaryFactory.XOR.create(null, null));
                case "not" -> myExpressions.add(UnaryFactory.NOT.create(null));
                case "true" -> myExpressions.add(ValueFactory.VALUE.create(true));
                case "false" -> myExpressions.add(ValueFactory.VALUE.create(false));
                case "(" -> {
                    //Erst die Klammerausdrücke durch rekursiven Aufruf verarbeiten
                    int klammern = 0;
                    List<String> inParas = new ArrayList<>();
                    //Ausdruck in den Klammern finden mit zugehöriger schließender Klammer
                    while (!ausdruckListe.get(i).equals(")") || klammern != 1) {
                        if (ausdruckListe.get(i).equals(")")) klammern--;
                        if (ausdruckListe.get(i).equals("(")) klammern++;
                        if (klammern < 0 || (i + 1) > ausdruckListe.size() - 1)
                            throw new IllegalArgumentException("Der eingegebene Ausdruck ist " +
                                    "syntaktisch nicht korrekt!\nDer folgende Teil ist fehlerhaft: " + expression);
                        inParas.add(ausdruckListe.get(i));
                        ausdruckListe.remove(i);
                    }
                    inParas.add(ausdruckListe.get(i));
                    inParas.remove(inParas.size() - 1);
                    inParas.remove(0);
                    ausdruckListe.remove(i);
                    i--;
                    //Klammerausdruck wieder in einen für den Parser richtig formatierten String verwandeln
                    StringBuilder sb = new StringBuilder();
                    for (String s : inParas) {
                        sb.append(s).append(" ");
                    }
                    //Rekursion starten
                    myExpressions.add(parseString(sb.toString()));

                }
                case ")" -> {
                }
                //unbekanntes Zeichen im Ausdruck-String gefunden
                default -> throw new IllegalArgumentException("Der eingegebene Ausdruck ist syntaktisch nicht " +
                        "korrekt!\nDer folgende Teil ist fehlerhaft: " + expression +
                        " an der Stelle: " + ausdruckListe.get(i));
            }
        }



        /*
         * Erst alle NotExpression verarbeiten, da sie die höchste Bindung haben
         */
        for (int i = myExpressions.size() - 1; i >= 0; i--) {
            i = myExpressions.get(i).acceptVisitor(new VisitorBuildNot(), myExpressions, i);
        }

        /*
         * Danach alle AndExpressions verbinden, da sie als nächsthöhere Operator in der Hierarchie stehen
         */
        for (int i = 1; i < myExpressions.size() - 1; i++) {
            i = myExpressions.get(i).acceptVisitor(new VisitorBuildAnd(), myExpressions, i);
        }

        /*
         * Als Letztes XorExpression und OrExpression verbinden. Da sie die gleiche Rangfolge haben,
         * können diese beiden Operatorn gemeinsam verarbeitet werden
         */
        for (int i = 1; i < myExpressions.size(); i++) {
            i = myExpressions.get(i).acceptVisitor(new VisitorBuildRest(), myExpressions, i);
        }

        /*
         * Die Methode darf nur einen Ausdruck zurückgeben. Andererseits war die Eingabe falsch
         */
        if (myExpressions.size() > 1) {
            throw new IllegalArgumentException("Der eingegebene Ausdruck ist syntaktisch nicht korrekt!\n" +
                    "Der folgende Teil ist fehlerhaft: " + expression);
        }
        return myExpressions.get(0);
    }

}
