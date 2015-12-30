/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThreeMusketeers
 * Created on 25-Oct-2015
 */
public class SMPLPrintStmt extends SMPLStatement {

    String separator;
    ASTExp<AIRExp> expression;
    String str;

    public SMPLPrintStmt(String separator, ASTExp<AIRExp> expression) {
        this.separator = separator; //Determines whether print or println; "" - print, "\n" - println
        this.expression = expression; //Value to be printed
        this.str = null;
    }

    public SMPLPrintStmt(String separator, String str){
        this.separator = separator;
        this.expression = null;
        this.str =str;
    }

    public  String getSeparator() {
        return separator;
    }

    public ASTExp<AIRExp> getExpression() {
        return expression;
    }
    
    @Override
    public <S, T> T visit(SMPLVisitor<S, T> v, S state) throws SMPLException {
        return v.visitSMPLPrintStmt(this, state);
    }

}
