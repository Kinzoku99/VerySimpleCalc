package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Just a customized label.
 */
public class CalcLabel extends JLabel {
    private final Font myFont = new Font("MV Boli",Font.PLAIN,20);

    /**
     * Constructor
     * @param x : left upper corner x coordinate
     * @param y : left upper corner y coordinate
     */
    CalcLabel(int x,int y) {
        setText("0");
        setForeground(Color.PINK);
        setBorder(BorderFactory.createBevelBorder(1));
        setFont(myFont);
        setBounds(x,y,360,50);
    }
}
