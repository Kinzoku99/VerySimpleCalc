package com.company.ButtonPad;

import com.company.Buttons.CalcButton;

import java.util.ArrayList;


public interface ButtonPad {
    /**
     * Getter
     * @return buttons contained by a ButtonPad
     */
    ArrayList<CalcButton> getButtons();
}
