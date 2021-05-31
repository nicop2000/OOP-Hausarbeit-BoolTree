package de.fhkiel.main;

public class MAIN {

    public static void main(String[] args) {
        Assertion myAssertion = new AndAssertion(new Value(true), new OrAssertion(new Value(false), new AndAssertion(new Value(true), new Value(false))));
        Assertion myAssertion2 = new AndAssertion(new Value(true), new OrAssertion(new Value(false), new AndAssertion(new Value(true), new NOT(new Value(false)))));
        myAssertion.print();
        System.out.println();
        System.out.println(myAssertion.getLogicalValue());
        myAssertion2.print();
        System.out.println();
        System.out.println(myAssertion2.getLogicalValue());

        String myBoolExpression = "true && false || true || –false && true";

        /*
        if ("true") new Value(true)
        if ("&&") new AndAssertion
         */
    }
}
