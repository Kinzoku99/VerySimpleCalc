package com.company.Buttons;

import com.company.CalcCoordinates;

import javax.swing.*;

/**
 * Button that reprezents an arithmetic operation.
 */
public class ArithmeticButton extends CalcButton {
    private final String type;

    /**
     * Constructor
     * @param op : operator name
     * @param v : left upper corner coordinates
     * @param dim : dimention of button
     * @param label : label where commands are sumbitted
     */
    public ArithmeticButton(String op, CalcCoordinates v, CalcCoordinates dim, JLabel label) {
        super(v,dim,label);
        type = op;
        setText(op);
    }

    /**
     * Checks if character is an operator
     * @param c : character
     * @return is character an operator
     */
    private boolean isOpChar(char c) {
        return c == '+' || c == '*' || c == '/' || c=='-';
    }

    @Override
    protected void react() {
        String oldText = label.getText();
        char last = oldText.charAt(oldText.length()-1);
        if(isOpChar(last))
            System.err.println("Wrong input!");
        else if(!oldText.equals("0") || !type.equals("+"))
            label.setText(oldText + type);
    }
}
