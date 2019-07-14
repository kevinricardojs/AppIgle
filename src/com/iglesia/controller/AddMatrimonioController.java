package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.iglesia.view.MarcoApp;
import com.iglesia.view.forms.AddMatrimonio;

public class AddMatrimonioController implements ActionListener{
	private MarcoApp panel;
	
	public AddMatrimonioController(MarcoApp panel) {
		super();
		this.panel = panel;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//panel.mainPanel.add(new AddMatrimonio(), "grow");
		panel.mainPanel.remove(panel.panelPersona);
		panel.mainPanel.remove(panel.panelMatrimonio);
		panel.mainPanel.remove(panel.panelPresentacion);

		panel.panelMatrimonio = new AddMatrimonio();
		CapturarMatrimonioController captura = new CapturarMatrimonioController(panel.panelMatrimonio);
		panel.mainPanel.add(panel.panelMatrimonio, "center, growy, width 700");
		SwingUtilities.updateComponentTreeUI(panel);

	}
	
	

}
