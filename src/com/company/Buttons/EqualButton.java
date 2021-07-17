package com.company.Buttons;

import com.company.EquationElement.Number;
import com.company.EquationElement.*;
import com.company.CalcCoordinates;

import javax.swing.*;

/**
 * Button used to simplify the equation.
 */
public class EqualButton extends CalcButton {
    /**
     * Constructor
     * @param v : left upper corner coordinates
     * @param dim : dimention of button
     * @param label : label where commands are sumbitted
     */
    public EqualButton(CalcCoordinates v, CalcCoordinates dim, JLabel label) {
        super(v, dim, label);
        setText("=");
    }

    /**
     * This method changes string representing equation to equation which is able to count itself.
     * @param string : equation string reprezentation
     * @return equation which is able to count itself
     */
    private EquationElement simplify(String string) {
        if(string.isEmpty())
            return new Number("0");
        else if(string.contains("+") || string.contains("-")) {
            int index1 = string.indexOf("+");
            int index2 = string.indexOf("-");
            if (index2 == -1)
                return new PlusOperator(simplify(string.substring(0,index1)), simplify(string.substring(index1+1)));
            else if (index1 == -1)
                return new MinusOperator(simplify(string.substring(0,index2)), simplify(string.substring(index2+1)));
            else {
                int max = Math.max(index1,index2);
                if(max==index1)
                    return new PlusOperator(simplify(string.substring(0,index1)), simplify(string.substring(index1+1)));
                else
                    return new MinusOperator(simplify(string.substring(0,index2)), simplify(string.substring(index2+1)));
            }
        }
        else if(string.contains("*") || string.contains("/")) {
            int index1 = string.indexOf("*");
            int index2 = string.indexOf("/");
            if (index2 == -1)
                return new MulOperator(simplify(string.substring(0,index1)), simplify(string.substring(index1+1)));
            else if (index1 == -1)
                return new DivOperator(simplify(string.substring(0,index2)), simplify(string.substring(index2+1)));
            else {
                int max = Math.max(index1,index2);
                if(max==index1)
                    return new MulOperator(simplify(string.substring(0,index1)), simplify(string.substring(index1+1)));
                else
                    return new DivOperator(simplify(string.substring(0,index2)), simplify(string.substring(index2+1)));
            }
        }
        else if(string.contains(("^"))) {
            int index = string.indexOf("^");
            return new PowOperator(simplify(string.substring(0,index)), simplify(string.substring(index+1)));
        }
        else if(string.contains("!")) {
            int index = string.indexOf("!");
            if(index != string.length()-1)
                throw new ArithmeticException();
            else
                return new FactorialOperator(simplify(string.substring(0,index)));
        }
        else
            return new Number(string);
    }

    @Override
    protected void react() {
        String equation = label.getText();
        EquationElement result = simplify(equation);
        label.setText(result.getValue().getValue().toString());
    }
}
