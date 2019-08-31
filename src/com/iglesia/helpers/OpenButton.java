package com.iglesia.helpers;

import javax.swing.JButton;

public class OpenButton extends JButton{
	String DPI;
	public OpenButton(String texto, String dpi) {
		super(texto);
		this.DPI = dpi;
	}

}
