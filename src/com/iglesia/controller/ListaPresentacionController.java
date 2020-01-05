package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.iglesia.view.MarcoApp;
import com.iglesia.view.Listas.MatrimoniosList;
import com.iglesia.view.Listas.PresentacionesList;
import com.iglesia.view.Listas.UsuariosList;

public class ListaPresentacionController implements ActionListener{
	private MarcoApp panel;
	
	public ListaPresentacionController(MarcoApp panel) {
		super();
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel.mainPanel.remove(panel.panelPersona);
		panel.mainPanel.remove(panel.panelMatrimonio);
		panel.mainPanel.remove(panel.panelPresentacion);
		panel.mainPanel.remove(panel.panelUserList);
		panel.mainPanel.remove(panel.panelMatrimonioList);
		panel.mainPanel.remove(panel.panelPresentacionList);
		PresentacionesList lista = new PresentacionesList();
		
		panel.panelPresentacionList = lista;
		panel.mainPanel.add(panel.panelPresentacionList	, "center, growy, width 1000");
		SwingUtilities.updateComponentTreeUI(panel);

	}

}
