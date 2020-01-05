package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.iglesia.view.MarcoApp;
import com.iglesia.view.Listas.MatrimoniosList;
import com.iglesia.view.Listas.UsuariosList;

public class ListaPersonaController implements ActionListener{
	private MarcoApp panel;
	
	public ListaPersonaController(MarcoApp panel) {
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
		UsuariosList lista = new UsuariosList();
		panel.panelUserList = lista;
		panel.mainPanel.add(panel.panelUserList, "center, growy, width 700");
		SwingUtilities.updateComponentTreeUI(panel);

	}

}
