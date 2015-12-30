/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * An enumeration of all unary arithmetic operations.
 * @author ThreeMusketeers
 * Created on 28-Oct-2015
 */
public enum UnOpArith implements UnaryOp<Double, Double>{
    INC("++") {
        @Override
        public Double apply(Double arg) {
            return arg + 1;
        }
    },
    DEC("--") {
        @Override
        public Double apply(Double arg) {
            return arg - 1;
        }
    },
    NEG("-") {
        @Override
        public Double apply(Double arg) {
            return -arg;
        }
    },
    NOT("not") {
        @Override
        public Double apply(Double arg) {
            return arg == 1 ? new Double(0) : new Double(1);
        }
    },
    BNOT("~") {
        @Override
        public Double apply(Double arg) {
            int val = arg.intValue();
            return new Double(~val);
        }
    },
    ;
    
    String symbol;

    UnOpArith(String symbol) {
        this.symbol = symbol;
    }

    
       @Override
    public String getSymbol() {
        return symbol;
    }
}
