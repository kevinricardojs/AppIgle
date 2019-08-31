package com.iglesia.helpers;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class JLabelColored extends JLabel{
	
	public JLabelColored(String text, String color) {
		super(text);
		this.setForeground(Color.decode(color));
		this.setFont(new Font("Century Gothic", Font.BOLD, 15));
	}
	
	public JLabelColored(String text, String color, String fondo) {
		super(text);
		this.setForeground(Color.decode(color));
		this.setFont(new Font("Century Gothic", Font.BOLD, 15));
		this.setBackground(Color.decode(fondo));
		this.setOpaque(true);
	}
	
	
}
