package com.company.Buttons;

import com.company.CalcCoordinates;

import javax.swing.*;

/**
 * Button representing numbers.
 */
public class NumberButton extends CalcButton {
    private final String number;

    /**
     * Constructor
      @param number : number to represent
     * @param v : left upper corner coordinates
     * @param dim : dimention of button
     * @param label : label where commands are sumbitted
     */
    public NumberButton(String number, CalcCoordinates v, CalcCoordinates dim, JLabel label) { //x = 200, y = 80
        super(v, dim, label);
        this.number = number;
        setText(number);
    }

    @Override
    protected void react() {
        String oldText = label.getText();

        if(oldText.charAt(oldText.length()-1)=='!') {
            System.err.println("Wrong input!");
            return;
        }

        if(oldText.equals("0"))
            label.setText(number);
        else if(oldText.equals("0-"))
            label.setText("-" + number);
        else
            label.setText(oldText + number);
    }
}
