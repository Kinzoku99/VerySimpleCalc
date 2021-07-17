package com.company;

import com.company.ButtonPad.ArithmeticPad;
import com.company.ButtonPad.NumberPad;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400,360);
		frame.setTitle("Very Simple Calculator");
		frame.setResizable(false);

		CalcLabel label = new CalcLabel(10,10);
		NumberPad numberPad = new NumberPad(new CalcCoordinates(210,80), 50, label);
		ArrayList<JButton> buttons = new ArrayList<>(numberPad.getButtons());
		ArithmeticPad arithmeticPad = new ArithmeticPad(new CalcCoordinates(10,80), 50,label);

		buttons.addAll(arithmeticPad.getButtons());

		for(JButton button : buttons)
			frame.add(button);

		frame.add(label);

		JButton cheater = new JButton();
		frame.add(cheater);
		cheater.setVisible(false);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
