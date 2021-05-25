package de.fhkiel.main;

public class MAIN {

    public static void main(String[] args) {
        Assertion myAssertion = new AndExpression(new Value(true), new OrExpression(new Value(false), new AndExpression(new Value(true), new Value(false))));
        Assertion myAssertion2 = new AndExpression(new Value(true), new OrExpression(new Value(false), new AndExpression(new Value(true), new NOT(new Value(false)))));
        myAssertion.print();
        System.out.println();
        System.out.println(myAssertion.getLogicalValue());
        myAssertion2.print();
        System.out.println();
        System.out.println(myAssertion2.getLogicalValue());
    }
}
