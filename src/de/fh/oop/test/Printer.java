package de.fh.oop.test;

import de.fh.oop.treenodes.AndExpression;
import de.fh.oop.treenodes.Expression;
import de.fh.oop.treenodes.Value;

import java.util.List;

public class Printer {

    private static Integer einrueckungFirst = 0;
    private static Integer einrueckungLeft = 0;
    private static Integer einrueckungRight = 0;

    public static void printObj(Expression myEx) {

        einrueckungFirst = (int) Math.pow(2.0,  (float) myEx.size());
        einrueckungLeft = einrueckungFirst - 2;
        einrueckungRight = einrueckungFirst + 2;
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, einrueckungFirst)));
        System.out.println(sb.toString() + myEx);
        printObj(myEx);

    }
    public static void printObj(AndExpression myEx) {

        einrueckungFirst += (int) Math.pow(2.0,  (float) myEx.size());
        einrueckungLeft = einrueckungFirst - 2;
        einrueckungRight = einrueckungFirst + 2;
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, einrueckungFirst)));
        System.out.println(sb.toString() + myEx);




    }

}
