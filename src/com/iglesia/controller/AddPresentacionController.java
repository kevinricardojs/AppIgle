package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.iglesia.view.MarcoApp;
import com.iglesia.view.forms.AddPresentacion;

public class AddPresentacionController implements ActionListener{
	private MarcoApp panel;
	
	public AddPresentacionController(MarcoApp panel) {
		super();
		this.panel = panel;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//panel.mainPanel.add(new AddPresentacion(), "grow");
		panel.mainPanel.remove(panel.panelPersona);
		panel.mainPanel.remove(panel.panelMatrimonio);
		panel.mainPanel.remove(panel.panelPresentacion);

		panel.panelPresentacion = new AddPresentacion();
		panel.mainPanel.add(panel.panelPresentacion, "grow");
		SwingUtilities.updateComponentTreeUI(panel);

	}

}
