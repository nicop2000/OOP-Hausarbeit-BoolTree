package de.fh.oop.util;

import de.fh.oop.treenodes.Expression;
import de.fh.oop.util.factory.BinaryFactory;
import de.fh.oop.util.factory.UnaryFactory;
import de.fh.oop.util.visitor.VisitorBuildTree;
import de.fh.oop.util.visitor.VisitorNot;
import de.fh.oop.util.factory.ValueFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {


    public static Expression parseString(String expression) {
        String[] ausdruck = expression.toLowerCase().split(" ");
        List<String> ausdruckListe = new ArrayList<>();
        List<Expression> myExpressions = new ArrayList<>();
        List<String> inParas = new ArrayList<>();
        Collections.addAll(ausdruckListe, ausdruck);
        for (int i = 0; i < ausdruckListe.size(); i++) {
            switch (ausdruckListe.get(i)) {
                case "&&" -> myExpressions.add(BinaryFactory.AND.create(null, null));
                case "||" -> myExpressions.add(BinaryFactory.OR.create(null, null));
                case "^" -> myExpressions.add(BinaryFactory.XOR.create(null, null));
                case "NOT" -> myExpressions.add(UnaryFactory.NOT.create(null));
                case "true" -> myExpressions.add(ValueFactory.VALUE.create(true));
                case "false" -> myExpressions.add(ValueFactory.VALUE.create(false));
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
                    myExpressions.add(parseString(sb.toString()));
                }
            }
        }
        if (myExpressions.size() > 1) {
            for (int i = 0; i < myExpressions.size(); i++) {
                i = myExpressions.get(i).acceptVisitor(VisitorNot.getInstance(), myExpressions, i);

            }
            for (int i = 1; i < myExpressions.size() && myExpressions.size() > 1; i++) {
                i = myExpressions.get(i).acceptVisitor(VisitorBuildTree.getInstance(), myExpressions, i);

            }
        }
        if (myExpressions.size() > 1) {
        throw new IllegalArgumentException("Der eingegebene Ausdruck ist syntaktisch nicht korrekt! Der folgende Teil ist fehlerhaft: " + expression);

}
        return  myExpressions.get(0);
    }
}
