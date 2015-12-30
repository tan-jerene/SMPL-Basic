/**
 * <code>SMPLExp</code> is the parent class for all arithmetic
 * expressions.  Since numbers may not be named by SMPL variables, no
 * environment is needed to evaluate arithmetic expressions.
 *
 * @author ThreeMusketeers
 * @version 1.0
 */
public abstract class SMPLExp extends ASTExp<SMPLExp> {

    public SMPLExp() {
    super();
    }
    /**************FUNCTIONALITY PROVIDED BY BinaryOpArith*************/
    public abstract <S, T> T visit(SMPLVisitor<S, T> v, S arg) throws SMPLException;

    @Override
    public <S, T> T visit(ASTVisitor<SMPLExp, S, T> v, S state) throws SMPLException {
        // We have to delegate to the more specific visit method from here.
        return visit((SMPLVisitor<S, T>) v, state);
    }
}
