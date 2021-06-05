package de.fhkiel.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserNeu {


    public static Assertion parseString(String expression) {
        String[] ausdruck = expression.split(" ");
        List<String> ausdruckListe = new ArrayList<>();
        List<Assertion> myAssertions = new ArrayList<>();
        List<String> inParas = new ArrayList<>();
        for (int i = 0; i < ausdruck.length; i++) {
            ausdruckListe.add(ausdruck[i]);
        }
        for (int i = 0; i < ausdruckListe.size(); i++) {
            switch (ausdruckListe.get(i)) {
                case "&&":
                    myAssertions.add(new AndAssertion(null, null));
                    break;
                case "||":
                    myAssertions.add(new OrAssertion(null, null));
                    break;
                case "^":
                    myAssertions.add(new XOR(null, null));
                    break;
                case "NOT":
                    myAssertions.add(new NOT(null));
                    break;
                case "true":
                    myAssertions.add(new Value(true));
                    break;
                case "false":
                    myAssertions.add(new Value(false));
                    break;
                case "(":
                    int klammern = 0;
                    while(!ausdruckListe.get(i).equalsIgnoreCase(")") || klammern != 1) {
                        if (ausdruckListe.get(i).equalsIgnoreCase(")")) klammern --;
                        if (ausdruckListe.get(i).equalsIgnoreCase("(")) klammern ++;
                        inParas.add(ausdruckListe.get(i));
                        ausdruckListe.remove(i);
                    }
                    inParas.add(ausdruckListe.get(i));
                    inParas.remove(inParas.size() - 1);
                    inParas.remove(0);
                    ausdruckListe.remove(i);
                    i--;
                    System.out.println("InParas: " + inParas.toString());
                    StringBuilder sb = new StringBuilder();
                    for (String s: inParas) {
                        sb.append(s + " ");
                    }
                    String newString = sb.toString();
                    myAssertions.add(parseString(sb.toString()));
                break;
            }
        }
        if (myAssertions.size() > 1) {
            for (int i = 0; i < myAssertions.size(); i++) {
                switch (myAssertions.get(i).acceptVisitor(new Visitor())) {
                    case "not":
                        myAssertions.set(i, new NOT(myAssertions.get(i + 1)));
                        myAssertions.remove(i + 1);
                        break;
                }
            }
            for (int i = 0; i < myAssertions.size(); i++) {
                switch (myAssertions.get(i).acceptVisitor(new Visitor())) {
                    case "and":
                        myAssertions.set(i, new AndAssertion(myAssertions.get(i - 1), myAssertions.get(i + 1)));
                        myAssertions.remove(i + 1);
                        myAssertions.remove(i - 1);
                        i--;
                        break;
                    case "or":
                        myAssertions.set(i, new OrAssertion(myAssertions.get(i - 1), myAssertions.get(i + 1)));
                        myAssertions.remove(i + 1);
                        myAssertions.remove(i - 1);
                        i--;
                        break;
                    case "xor":
                        myAssertions.set(i, new XOR(myAssertions.get(i - 1), myAssertions.get(i + 1)));
                        myAssertions.remove(i + 1);
                        myAssertions.remove(i - 1);
                        i--;
                        break;

                }
            }
        }
        int b = 3;



if (myAssertions.size() > 1) {
        throw new IllegalArgumentException("Der eingegebene Ausdruck ist syntaktisch nicht korrekt! Der folgende Teil ist fehlerhaft: " + expression);

}
        return  myAssertions.get(0);
    }
}
