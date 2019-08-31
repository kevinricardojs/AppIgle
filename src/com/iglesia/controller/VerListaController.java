package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.iglesia.view.MarcoApp;

public class VerListaController implements ActionListener{
	private MarcoApp panel;
	
	public VerListaController(MarcoApp panel) {
		super();
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Aqui");

		panel.mainPanel.remove(panel.panelPersona);
		panel.mainPanel.remove(panel.panelMatrimonio);
		panel.mainPanel.remove(panel.panelPresentacion);
		
		panel.mainPanel.add(panel.panelUserList, "center, growy, width 700");
		SwingUtilities.updateComponentTreeUI(panel);

	}

}
