package com.iglesia.helpers;

import javax.swing.JButton;

public class OpenButton extends JButton{
	public int id_persona;
	public OpenButton(String texto, int id) {
		super(texto);
		this.id_persona = id;
	}

}
