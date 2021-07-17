package com.company.EquationElement;

import com.company.CalcValue;

/**
 * This operator adds right and left elements.
 */
public class PlusOperator extends ArithmeticOperator {
    /**
     * Constructor
     * @param left : equation element on the left of an operator
     * @param right : equation element on the right of an operator
     */
    public PlusOperator(EquationElement left, EquationElement right) {
        super(left, right);
    }

    @Override
    protected CalcValue operate(EquationElement left, EquationElement right) {
        return left.getValue().add(right.getValue());
    }
}
