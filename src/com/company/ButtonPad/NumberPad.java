package com.company.ButtonPad;

import com.company.Buttons.CalcButton;
import com.company.Buttons.ClearButton;
import com.company.Buttons.NumberButton;
import com.company.Buttons.PlusMinusButton;
import com.company.CalcCoordinates;

import javax.swing.*;
import java.util.ArrayList;

public class NumberPad extends GridButtonPad {
    private final ArrayList<CalcButton> buttons;

    /**
     * Constructor
     * @param v : left upper corner coordinates
     * @param size : size of buttons
     * @param label : label where commands are sumbitted
     */
    public NumberPad(CalcCoordinates v, int size, JLabel label) {
        super(3,4,50,5,v);

        buttons = new ArrayList<>();
        CalcCoordinates dim = new CalcCoordinates(size,size);

        for(int i = 1; i < 10; i++)
            buttons.add(new NumberButton(Integer.toString(i), getNextVector(), dim, label));

        buttons.add(new PlusMinusButton(getNextVector(), dim, label));
        buttons.add(new NumberButton("0", getNextVector(), dim, label));
        buttons.add(new ClearButton(getNextVector(), dim, label));
    }

    @Override
    public ArrayList<CalcButton> getButtons() {
        return buttons;
    }
}
