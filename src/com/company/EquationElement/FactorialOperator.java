package com.company.EquationElement;

import com.company.CalcValue;

/**
 * Operator that takes a number and does factorial on it.
 */
public class FactorialOperator implements EquationElement {
    private final EquationElement element;

    /**
     * Constructor
     * @param element : equation element which factorial is taken from
     */
    public FactorialOperator(EquationElement element) {
        this.element = element;
    }

    @Override
    public CalcValue getValue() {
        return element.getValue().factorial();
    }
}
