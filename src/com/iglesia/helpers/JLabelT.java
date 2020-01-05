package com.iglesia.helpers;

import java.awt.Font;

import javax.swing.JLabel;

public class  JLabelT extends JLabel{
	public  JLabelT(String text, String font, int size, boolean bold) {
		super(text);
		
		if(bold) {
			this.setFont(new Font(font, Font.BOLD, size));
		}
		else {
			this.setFont(new Font(font, Font.ITALIC, size));
		}
			
		
	}
}
