package com.company.Buttons;

import com.company.CalcCoordinates;

import javax.swing.*;

/**
 * Button reprezenting Factorial.
 */
public class FactorialButton extends CalcButton{
    /**
     * Constructor
     * @param v : left upper corner coordinates
     * @param dim : dimention of button
     * @param label : label where commands are sumbitted
     */
    public FactorialButton(CalcCoordinates v, CalcCoordinates dim, JLabel label) {
        super(v, dim, label);
        setText("!");
    }

    /**
     * Checks if character is an operator
     * @param c : character
     * @return is character an operator
     */
    private boolean isOpChar(char c) {
        return c == '+' || c == '*' || c == '/' || c=='-' || c=='!';
    }

    @Override
    protected void react() {
        String oldText = label.getText();
        char last = oldText.charAt(oldText.length()-1);
        if(isOpChar(last))
            System.err.println("Wrong input!");
        else
            label.setText(oldText + "!");
    }
}
