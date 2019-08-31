package com.iglesia.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.iglesia.view.MarcoApp;
import com.iglesia.view.forms.AddPersona;

import net.miginfocom.swing.MigLayout;

public class AddPersonaController implements ActionListener{
	private MarcoApp panel;
	
	public AddPersonaController(MarcoApp panel) {
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
		panel.mainPanel.remove(panel.panelUserList);

		panel.panelPersona = new AddPersona();
		
		panel.mainPanel.add(panel.panelPersona, "center, growy, width 700");
		
		CapturarPersonaController captura = new CapturarPersonaController(panel.panelPersona);
		
		SwingUtilities.updateComponentTreeUI(panel);
		


	}

}
