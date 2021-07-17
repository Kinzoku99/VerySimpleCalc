package com.company.EquationElement;

import com.company.CalcValue;

/**
 * This equationElement represents the number.
 */
public class Number implements EquationElement {
    private final CalcValue value;

    /**
     * Constructor
     * @param string : value
     */
    public Number(String string) {
        value = new CalcValue(string);
    }

    @Override
    public CalcValue getValue() {
        return value;
    }
}
