package de.fh.oop.util.visitor;

import de.fh.oop.treenodes.*;

public class VisitorAusgabe {

    private static VisitorAusgabe instance = null;
    public synchronized static VisitorAusgabe getInstance() {
        if (instance == null) {
            instance = new VisitorAusgabe();
        }
        return instance;
    }
    private VisitorAusgabe() {}

    public String codeausgabe(AndExpression and) {
        return "new AndExpression(" + and.getLeftBranch().codeausgabe(new VisitorAusgabe()) + ", " +
                and.getRightBranch().codeausgabe(new VisitorAusgabe()) + ")";

    }
    public String codeausgabe(OrExpression or) {
        return "new OrExpression(" + or.getLeftBranch().codeausgabe(new VisitorAusgabe()) + ", " +
                or.getRightBranch().codeausgabe(new VisitorAusgabe()) + ")";
    }
    public String codeausgabe(XorExpression xorExpression) {
        return "new XorExpression(" + xorExpression.getLeftBranch().codeausgabe(new VisitorAusgabe()) + ", " +
                xorExpression.getRightBranch().codeausgabe(new VisitorAusgabe()) + ")";
    }
    public String codeausgabe(NotExpression notExpression) {
        return "new NotExpression(" + notExpression.getMyNOTAssertion().codeausgabe(new VisitorAusgabe()) + ")";
    }

    public String codeausgabe(Value val) {
        return "new Value(" + val.getLogicalValue() + ")";

    }



}
