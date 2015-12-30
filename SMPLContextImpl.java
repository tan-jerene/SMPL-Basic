import java.util.ArrayList;

/**
 *
 * @author ThreeMusketeers
 * Created on 19-Dec-2015
 */
public class SMPLContextImpl implements SMPLContext {
    //private SMPLEnvironment<SMPLFunction> fnEnv;
    private SMPLEnvironment<Double> dEnv;
    private SMPLEnvironment<String> sEnv;
    private SMPLEnvironment<Boolean> bEnv;

     public SMPLContextImpl( /*SMPLEnvironment<SMPLFunction> fnEnv, */SMPLEnvironment<Double> dEnv, SMPLEnvironment<String> sEnv, SMPLEnvironment<Boolean> bEnv){
        //this.fnEnv = fnEnv;
        this.dEnv = dEnv;
        this.sEnv = sEnv;
        this.bEnv = bEnv;
     }
     public SMPLContextImpl(){
        //this.fnEnv = null;
        this.dEnv = new SMPLEnvironment<Double>();
        this.sEnv = new SMPLEnvironment<String>();
        this.bEnv = new SMPLEnvironment<Boolean>();
     }

    /**
     * Create a new context in which the function environment is extended with
     * new bindings.
     * @param fParams The names to be bound in the new function frame.
     * @param args The corresponding values for the names
     * @return A newly created context containing the new function environment,
     * but leaving all the other components of the context unchanged.
     *//*
    public SMPLContext extendF(ArrayList<String> fParams, ArrayList<SMPLFunction> args){ 
            return new SMPLContextImpl(new SMPLEnvironment<SMPLFunction>(this.fnEnv, fParams, args), this.dEnv, this.sEnv, this.bEnv);
        }*/

    /**
     * Create a new context in which the numerical environment is extended with
     * new bindings.
     * @param nParams The names to be bound in the new numerical environment
     * frame.
     * @param vals The corresponding values for the names
     * @return A newly created context containing the new numerical environment,
     * but leaving all the other components of the context unchanged.
     */
    public SMPLContext extendN(ArrayList<String> nParams, ArrayList<Double> vals){ 
      return new SMPLContextImpl(/*this.fnEnv, */new SMPLEnvironment<Double>(this.dEnv, nParams, vals), this.sEnv, this.bEnv);
    }

    /**
     * Create a new context in which the String environment is extended with
     * new bindings.
     * @param pParams The names to be bound in the new String environment frame.
     * @param args The corresponding values for the names
     * @return A newly created context containing the new String environment,
     * but leaving all the other components of the context unchanged.
     */
    public SMPLContext extendS(ArrayList<String> sParams, ArrayList<String> args){  
        return new SMPLContextImpl(/*this.fnEnv, */this.dEnv, new SMPLEnvironment<String>(this.sEnv, sParams, args), this.bEnv);
    }

    /**
     * Create a new context in which the String environment is extended with
     * new bindings.
     * @param pParams The names to be bound in the new String environment frame.
     * @param args The corresponding values for the names
     * @return A newly created context containing the new String environment,
     * but leaving all the other components of the context unchanged.
     */
    public SMPLContext extendB(ArrayList<String> bParams, ArrayList<Boolean> bools){  
        return new SMPLContextImpl(/*this.fnEnv, */this.dEnv, this.sEnv, new SMPLEnvironment<Boolean>(this.bEnv, bParams, bools));
    }

    /**
     * Lookup a reference to a SMPL function.
     * @param name The identifier of the SMPL function
     * @return The SMPL function associated with the given name in this context
     * @throws SMPLException if the name is not bound to a Painter in this
     * context
     *//*
    public SMPLFunction getF(String name) throws SMPLException{
        return this.fnEnv.get(name);
    }*/

    /**
     * Lookup a reference to a number
     * @param name The identifier of the Double
     * @return The number associated with the given name in this context
     * @throws SMPLException if the name is not bound to a number in this
     * context
     */
    public Double getN(String name) throws SMPLException{
        return this.dEnv.get(name);
    }

    /**
     *
     * @return The numerical environment associated with this context.
     */
    public SMPLEnvironment<Double> getNumEnv(){
        return this.dEnv;
    }

    /**
     * Lookup a reference to a String
     * @param name The identifier of the String
     * @return The String associated with the given name in this context
     * @throws SMPLException if the name is not bound to a String in this
     * context
     */
    public String getS(String name) throws SMPLException{
        return this.sEnv.get(name);
    }

    /**
     * Store a binding for the given name to the given SMPL function.
     * @param name The identifier of the binding
     * @param p The SMPL function to be associated with the name
     *//*
    public void putF(String name, SMPLFunction p){
      fnEnv.put(name, p);
    }*/

    /**
     * Store a binding for the given name to the given number.
     * @param name The identifier of the binding
     * @param n The numerical value to be associated with the name
     */
    public void putN(String name, Double n){
      dEnv.put(name, n);
    }

    /**
     * Store a binding for the given name to the given String.
     * @param name The identifier of the binding
     * @param p The String value to be associated with the name
     */
    public void putS(String name, String s){
            sEnv.put(name, s);
        }
  
    public void putB(String name, Boolean b){
            bEnv.put(name, b);
        }
    
}
