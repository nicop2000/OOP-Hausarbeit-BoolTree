package de.fhkiel.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {


    public static Assertion parseString(String expression) {
        String[] ausdruck = expression.split(" ");

        List<Assertion> myAssertions = new ArrayList<>();
        for (int i = 0; i < ausdruck.length; i++) {
            if (ausdruck[i].equalsIgnoreCase("true") || ausdruck[i].equalsIgnoreCase("false")) {
                myAssertions.add((new Value(Boolean.valueOf(ausdruck[i]))));
            } else if (ausdruck[i].equalsIgnoreCase("&&")) myAssertions.add((new AndAssertion(null, null)));
            else if (ausdruck[i].equalsIgnoreCase("||")) myAssertions.add((new OrAssertion(null, null)));
            else if (ausdruck[i].equalsIgnoreCase("^")) myAssertions.add((new XOR(null, null)));
            else if (ausdruck[i].equalsIgnoreCase("NOT")) myAssertions.add((new NOT(null)));
            else if (ausdruck[i].equalsIgnoreCase("(")) myAssertions.add(null);
            else if (ausdruck[i].equalsIgnoreCase(")")) myAssertions.add(null);
        }

        List<String> neuAusdruck = new ArrayList<>();
        List<String> neuerAusdruck = new ArrayList<>();
        for (int i = 0; i < ausdruck.length; i++) {
            if (ausdruck[i].equalsIgnoreCase("(")) {
                int j = i;
                while(!ausdruck[j].equalsIgnoreCase(")")) {
                    neuAusdruck.add(ausdruck[j]);
                    j++;
                }
                neuAusdruck.add(")");
                int k = i;
                while(k <= j) {
                    myAssertions.remove(i);
                    k++;
                }
                break;
            }
            neuerAusdruck.add(ausdruck[i]);
        }

        String[] ausdrucke = new String[neuAusdruck.size() - 2];
        for (int i = 1; i < neuAusdruck.size() - 1; i++) {
            ausdrucke[i - 1] = neuAusdruck.get(i);
        }
        List<Assertion> myAssertions2 = new ArrayList<>();
        for (int i = 0; i < ausdrucke.length; i++) {
            if (ausdrucke[i].equalsIgnoreCase("true") || ausdrucke[i].equalsIgnoreCase("false")) {
                myAssertions2.add((new Value(Boolean.valueOf(ausdrucke[i]))));
            } else if (ausdrucke[i].equalsIgnoreCase("&&")) myAssertions2.add((new AndAssertion(null, null)));
            else if (ausdrucke[i].equalsIgnoreCase("||")) myAssertions2.add((new OrAssertion(null, null)));
            else if (ausdrucke[i].equalsIgnoreCase("^")) myAssertions2.add((new XOR(null, null)));
            else if (ausdrucke[i].equalsIgnoreCase("NOT")) myAssertions2.add((new NOT(null)));
        }

        myAssertions.removeIf(n -> (n == null));
        myAssertions.add(createAssertion(ausdrucke, myAssertions2));


        String[] neueAusdrucke = new String[neuerAusdruck.size()];
        for (int i = 0; i < neuerAusdruck.size(); i++) {
            neueAusdrucke[i] = neuerAusdruck.get(i);
        }
        System.out.println(Arrays.toString(ausdruck));
        createAssertion(neueAusdrucke, myAssertions);
        int i = 2;
        return myAssertions.get(0);
    }

    public static Assertion createAssertion(String[] ausdruck, List<Assertion> myAssertions) {
        for (int i = ausdruck.length - 1; i >= 0; i--) {
            if (ausdruck[i].equalsIgnoreCase("&&")) {
                myAssertions.set(i, (new AndAssertion(myAssertions.get(i - 1), myAssertions.get(i + 1))));
                myAssertions.remove(i + 1);
                myAssertions.remove(i - 1);
            }
            if (ausdruck[i].equalsIgnoreCase("||")) {
                myAssertions.set(i, (new OrAssertion(myAssertions.get(i - 1), myAssertions.get(i + 1))));
                myAssertions.remove(i + 1);
                myAssertions.remove(i - 1);
            }
            if (ausdruck[i].equalsIgnoreCase("^")) {
                myAssertions.set(i, (new XOR(myAssertions.get(i - 1), myAssertions.get(i + 1))));
                myAssertions.remove(i + 1);
                myAssertions.remove(i - 1);
            }
            if (ausdruck[i].equalsIgnoreCase("NOT")) {
                myAssertions.set(i, (new NOT(myAssertions.get(i + 1))));
                myAssertions.remove(i + 1);
            }
//            if (ausdruck[i].equalsIgnoreCase(")")) {
//                myAssertions.add(paranthesesFound(ausdruck, i, myAssertions));
//                int j = i - 1;
//
//                while (!ausdruck[j].equalsIgnoreCase("(")) {
//                    myAssertions.remove(j);
//                    j--;
//                    i--;
//                }
//                myAssertions.removeIf(n -> (n == null));
//            }
        }
        return myAssertions.get(0);
    }

    public static Assertion putTogether(List<Assertion> myAssertion) {

        for (int i = 0; i < myAssertion.size(); i++) {

        }

        return null;
    }

    public static Assertion paranthesesFound(String[] ausdruck, int occurence, List<Assertion> myAssertions) {

        List<Assertion> newAssertionsInParantheses = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < occurence; i++) {
            if (ausdruck[i].equalsIgnoreCase("(")) {
                start = i;
                break;
            }
        }
        String[] neuAusdruck = new String[occurence - start];

        int j = 0;

        for (int i = start; i < occurence; i++) {
            newAssertionsInParantheses.add(myAssertions.get(i));
            neuAusdruck[j] = ausdruck[i];
            j++;
        }
        newAssertionsInParantheses.removeIf(n -> (n == null));
        String[] neuNeuAusdruck = new String[neuAusdruck.length - 1];
        for (int i = 1; i < neuAusdruck.length; i++) {
            neuNeuAusdruck[i - 1] = neuAusdruck[i];
        }

        return createAssertion(neuNeuAusdruck, newAssertionsInParantheses);
    }
}
