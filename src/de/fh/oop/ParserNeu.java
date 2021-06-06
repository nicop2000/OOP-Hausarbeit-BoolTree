package de.fh.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParserNeu {


    public static Assertion parseString(String expression) {
        String[] ausdruck = expression.toLowerCase().split(" ");
        List<String> ausdruckListe = new ArrayList<>();
        List<Assertion> myAssertions = new ArrayList<>();
        List<String> inParas = new ArrayList<>();
        Collections.addAll(ausdruckListe, ausdruck);
        for (int i = 0; i < ausdruckListe.size(); i++) {
            switch (ausdruckListe.get(i)) {
                case "&&" -> myAssertions.add(new AndAssertion(null, null));
                case "||" -> myAssertions.add(new OrAssertion(null, null));
                case "^" -> myAssertions.add(new XOR(null, null));
                case "NOT" -> myAssertions.add(new NOT(null));
                case "true" -> myAssertions.add(new Value(true));
                case "false" -> myAssertions.add(new Value(false));
                case "(" -> {
                    int klammern = 0;
                    while (!ausdruckListe.get(i).equals(")") || klammern != 1) {
                        if (ausdruckListe.get(i).equals(")")) klammern--;
                        if (ausdruckListe.get(i).equals("(")) klammern++;
                        inParas.add(ausdruckListe.get(i));
                        ausdruckListe.remove(i);
                    }
                    inParas.add(ausdruckListe.get(i));
                    inParas.remove(inParas.size() - 1);
                    inParas.remove(0);
                    ausdruckListe.remove(i);
                    i--;
                    StringBuilder sb = new StringBuilder();
                    for (String s : inParas) {
                        sb.append(s).append(" ");
                    }
                    myAssertions.add(parseString(sb.toString()));
                }
            }
        }
        if (myAssertions.size() > 1) {
            for (int i = 0; i < myAssertions.size(); i++) {
                i = myAssertions.get(i).acceptVisitor(new VisitorNOT(), myAssertions, i);

            }
            for (int i = 0; i < myAssertions.size(); i++) {
                i = myAssertions.get(i).acceptVisitor(new VisitorBuildTree(), myAssertions, i);

            }
        }


        if (myAssertions.size() > 1) {
        throw new IllegalArgumentException("Der eingegebene Ausdruck ist syntaktisch nicht korrekt! Der folgende Teil ist fehlerhaft: " + expression);

}
        return  myAssertions.get(0);
    }
}
