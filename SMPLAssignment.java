/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThreeMusketeers
 * Created on 20-Dec-2015
 */
public class SMPLAssignment extends SMPLStatement {

    String varName;
    ASTExp<AIRExp> expression;

    public SMPLAssignment(String varName, ASTExp<AIRExp> expression) {
        this.varName = varName; //D;etermines whether print or println; "" - print, "\n" - println
        this.expression = expression; //Value to be printed
    }

    public  String getVarName() {
        return varName;
    }

    public ASTExp<AIRExp> getExpression() {
        return expression;
    }
    
    @Override
    public <S, T> T visit(SMPLVisitor<S, T> v, S state) throws SMPLException {
        return v.visitSMPLAssignment(this, state);
    }

}
