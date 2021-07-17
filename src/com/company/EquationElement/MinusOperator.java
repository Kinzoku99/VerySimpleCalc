package com.company.EquationElement;

import com.company.CalcValue;

/**
 * Operator that substracts right element from the left one.
 */
public class MinusOperator extends ArithmeticOperator {
    /**
     * Constructor
     * @param left : equation element on the left of an operator
     * @param right : equation element on the right of an operator
     */
    public MinusOperator(EquationElement left, EquationElement right) {
        super(left, right);
    }

    @Override
    protected CalcValue operate(EquationElement left, EquationElement right) {
        return left.getValue().subtract(right.getValue());
    }
}
