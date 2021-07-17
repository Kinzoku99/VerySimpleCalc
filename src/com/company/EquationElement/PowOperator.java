package com.company.EquationElement;

import com.company.CalcValue;

/**
 * This operator increases left element to the right power.
 */
public class PowOperator extends ArithmeticOperator {

    /**
     * Constructor
     * @param left : equation element on the left of an operator
     * @param right : equation element on the right of an operator
     */
    public PowOperator(EquationElement left, EquationElement right) {
        super(left, right);
    }

    @Override
    protected CalcValue operate(EquationElement left, EquationElement right) {
        return left.getValue().pow(right.getValue());
    }
}
