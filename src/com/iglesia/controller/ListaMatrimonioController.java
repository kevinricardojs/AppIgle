package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.iglesia.view.MarcoApp;
import com.iglesia.view.Listas.MatrimoniosList;
import com.iglesia.view.Listas.UsuariosList;

public class ListaMatrimonioController implements ActionListener{
	private MarcoApp panel;
	
	public ListaMatrimonioController(MarcoApp panel) {
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
		MatrimoniosList lista = new MatrimoniosList();
		
		panel.panelMatrimonioList = lista;
		panel.mainPanel.add(panel.panelMatrimonioList	, "center, growy, width 900");
		SwingUtilities.updateComponentTreeUI(panel);

	}

}
