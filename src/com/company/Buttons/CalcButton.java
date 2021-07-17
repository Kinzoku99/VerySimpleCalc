package com.company.Buttons;

import com.company.CalcCoordinates;

import javax.swing.*;
import java.awt.*;

/**
 * Button of the calculator
 */
public abstract class CalcButton extends JButton {
    protected final JLabel label;
    private static final Font myFont = new Font("Century Gothic",java.awt.Font.PLAIN,20);

    /**
     * Constructor
     * @param v : left upper corner coordinates
     * @param dim : dimention of button
     * @param label : label where commands are sumbitted
     */
    public CalcButton(CalcCoordinates v, CalcCoordinates dim, JLabel label) {
        this.label = label;
        setFont(myFont);
        setBounds(v.getX(), v.getY(), dim.getX(), dim.getY());
        addActionListener(e -> react());
    }

    /**
     * This metod defines how button should react on pressing.
     */
    protected abstract void react();
}
