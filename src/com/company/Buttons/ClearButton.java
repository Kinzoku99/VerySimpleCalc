package com.company.Buttons;

import com.company.CalcCoordinates;

import javax.swing.*;

/**
 * Button that clears the label.
 */
public class ClearButton extends CalcButton {
    /**
     * Constructor
     * @param v : left upper corner coordinates
     * @param dim : dimention of button
     * @param label : label where commands are sumbitted
     */
    public ClearButton (CalcCoordinates v, CalcCoordinates dim, JLabel label) {
        super(v, dim, label);
        setText("C");
    }

    @Override
    protected void react() {
        label.setText("0");
    }
}
