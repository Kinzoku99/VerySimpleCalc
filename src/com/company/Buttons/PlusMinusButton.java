package com.company.Buttons;

import com.company.CalcCoordinates;

import javax.swing.*;

public class PlusMinusButton extends CalcButton {
    /**
     * Constructor
     * @param v : left upper corner coordinates
     * @param dim : dimention of button
     * @param label : label where commands are sumbitted
     */
    public PlusMinusButton(CalcCoordinates v, CalcCoordinates dim, JLabel label) {
        super(v, dim, label);
        setText("±");
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
        if(oldText.isEmpty())
            return;

        StringBuilder textBuilder = new StringBuilder();

        for(char c : oldText.toCharArray())
            if(c == '+')
                textBuilder.append("-");
            else if(c == '-')
                textBuilder.append("+");
            else
                textBuilder.append(c);

        String newText = textBuilder.toString();

        if(!isOpChar(newText.charAt(0)) && !newText.equals("0"))
            newText = "-" + newText;
        else if(newText.charAt(0)=='+')
            newText = newText.substring(1);

        label.setText(newText);
    }
}
