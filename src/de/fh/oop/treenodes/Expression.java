package de.fh.oop.treenodes;

import de.fh.oop.util.visitor.Visitor4Tree;
import de.fh.oop.util.visitor.Visitor4Equals;
import de.fh.oop.util.visitor.Visitor4Upcasting;
import de.fh.oop.util.visitor.VisitorAusgabe;

import java.util.List;

public interface Expression {



    boolean getLogicalValue();

    Expression copy();

    boolean equalStructure(Visitor4Equals v, Expression expression);

    boolean equalContent(Expression expression);

//    boolean equalContent();

    void print(String einrueckung);

    Integer acceptVisitor(Visitor4Tree v, List<Expression> myExpression, int i);


    String codeausgabe(VisitorAusgabe v);

    int size();




}
