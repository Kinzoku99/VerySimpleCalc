package com.company.EquationElement;

import com.company.CalcValue;

/**
 * Operator that takes two arguments and operates on them.
 */
public abstract class ArithmeticOperator implements EquationElement {
    private final EquationElement left;
    private final EquationElement right;

    /**
     * Constructor
     * @param left : equation element on the left of an operator
     * @param right : equation element on the right of an operator
     */
    public ArithmeticOperator(EquationElement left, EquationElement right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Operates on the elements. Returns a value counted by an operator.
     * @param left : equation element on the left of an operator
     * @param right : equation element on the right of an operator
     * @return value of an operator
     */
    protected abstract CalcValue operate(EquationElement left, EquationElement right);

    @Override
    public final CalcValue getValue() {
        return operate(left,right);
    }
}
