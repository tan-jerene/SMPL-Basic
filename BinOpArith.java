/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Coore <daniel.coore@uwimona.edu.jm>
 */
public enum BinOpArith implements BinaryOp<Double, Double> {
    ADD("+") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg + rightArg;
        }        
    },
    SUB("-") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg - rightArg;
        }
    },
    DIV("/") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg / rightArg;
        }
    },
    MUL("*") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg * rightArg;
        }
    },
    MOD("%") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg % rightArg;
        }
    },
    POW("^") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return Math.pow(leftArg, rightArg);
        }
    },
    LTHAN("<") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg < rightArg ? new Double(1) : new Double(0);
        }
    },
    GTHAN(">") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg > rightArg ? new Double(1) : new Double(0);
        }
    },
    LTHANE("<=") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg <= rightArg ? new Double(1) : new Double(0);
        }
    },
    GTHANE(">=") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg >= rightArg ? new Double(1) : new Double(0);
        }
    },
    EQUAL("==") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg == rightArg ? new Double(1) : new Double(0);
        }
    },
    NEQUAL("!=") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            return leftArg != rightArg ? new Double(1) : new Double(0);
        }
    },
    OR("or") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            int lv = leftArg == 1.0 ? 1 : 0;
            int rv = rightArg == 1.0 ? 1 : 0;
            return new Double(lv | rv);
        }
    },
    AND("and") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            int lv = leftArg == 1.0 ? 1 : 0;
            int rv = rightArg == 1.0 ? 1 : 0;
            return new Double(lv & rv);
        }
    },
    BOR("|") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            int lv = leftArg.intValue();
            int rv = rightArg.intValue();
            return new Double(lv | rv);
        }
    },
    BAND("&") {
        @Override
        public Double apply(Double leftArg, Double rightArg) {
            int lv = leftArg.intValue();
            int rv = rightArg.intValue();
            return new Double(lv & rv);
        }
    },
    ;
    
    String symbol;

    BinOpArith(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return The symbol for this operator
     */
    @Override
    public String getSymbol() {
        return symbol;
    }
}
