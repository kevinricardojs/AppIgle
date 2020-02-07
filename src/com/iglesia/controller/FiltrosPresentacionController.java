package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.iglesia.BD.MatrimonioDB;
import com.iglesia.BD.PersonaDB;
import com.iglesia.BD.PresentacionDB;
import com.iglesia.view.Listas.MatrimoniosList;
import com.iglesia.view.Listas.PresentacionesList;
import com.iglesia.view.Listas.UsuariosList;

public class FiltrosPresentacionController implements ActionListener{
	public PresentacionesList panel;
	
	public FiltrosPresentacionController(PresentacionesList p) {
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.lista = PresentacionDB.busqueda(panel.campo.getText());
		panel.contenedor.removeAll();
		panel.contenedor.revalidate();
		panel.contenedor.repaint();
		panel.listar();
	}

}
