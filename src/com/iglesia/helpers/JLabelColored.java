package com.iglesia.helpers;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelColored extends JLabel{
	
	public JLabelColored(String text, String color) {
		super(text);
		this.setForeground(Color.decode(color));
		this.setFont(new Font("Century Gothic", Font.BOLD, 15));
	}
}
