package com.company.EquationElement;

import com.company.CalcValue;

/**
 * Operator that multiplies left and right elements.
 */
public class MulOperator extends ArithmeticOperator {
    /**
     * Constructor
     * @param left : equation element on the left of an operator
     * @param right : equation element on the right of an operator
     */
    public MulOperator(EquationElement left, EquationElement right) {
        super(left, right);
    }

    @Override
    protected CalcValue operate(EquationElement left, EquationElement right) {
        return left.getValue().multiply(right.getValue());
    }
}
