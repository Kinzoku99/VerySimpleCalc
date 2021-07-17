package com.company.ButtonPad;

import com.company.Buttons.*;
import com.company.CalcCoordinates;

import javax.swing.*;
import java.util.ArrayList;

public class ArithmeticPad extends GridButtonPad {
    private final ArrayList<CalcButton> buttons;

    /**
     * Constructor
     * @param v : left upper corner coordinates
     * @param size : size of buttons
     * @param label : label where commands are sumbitted
     */
    public ArithmeticPad(CalcCoordinates v, int size, JLabel label) {
        super(2,4,size,5,v);

        buttons = new ArrayList<>();
        CalcCoordinates dim = new CalcCoordinates(size,size);

        buttons.add(new ArithmeticButton("+",getNextVector(),dim, label));
        buttons.add(new ArithmeticButton("-",getNextVector(),dim,label));
        buttons.add(new ArithmeticButton("*",getNextVector(),dim, label));
        buttons.add(new ArithmeticButton("/",getNextVector(),dim, label));
        buttons.add(new ArithmeticButton("^",getNextVector(),dim, label));
        buttons.add(new FactorialButton(getNextVector(),dim,label));
        buttons.add(new EqualButton(new CalcCoordinates(v.getX(),v.getY()+165),new CalcCoordinates(105,50), label));
    }

    @Override
    public ArrayList<CalcButton> getButtons() {
        return buttons;
    }
}
