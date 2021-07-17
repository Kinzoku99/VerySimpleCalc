package com.company.EquationElement;

import com.company.CalcValue;

/**
 * Operator divides left element by the right one
 */
public class DivOperator extends ArithmeticOperator {
    /**
     * Constructor
     * @param left : equation element on the left of an operator
     * @param right : equation element on the right of an operator
     */
    public DivOperator(EquationElement left, EquationElement right) {
        super(left, right);
    }

    @Override
    protected CalcValue operate(EquationElement left, EquationElement right) {
        return left.getValue().divide(right.getValue());
    }
}
