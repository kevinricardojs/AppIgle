package com.iglesia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.iglesia.BD.PersonaDB;
import com.iglesia.view.Listas.UsuariosList;

public class FiltrosPersonaController implements ActionListener{
	public UsuariosList panel;
	
	public FiltrosPersonaController(UsuariosList p) {
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.lista = PersonaDB.busqueda(panel.campo.getText(),panel.sexo.getSelectedIndex(), panel.estado_civil.getSelectedIndex(), panel.miembro_activo.getSelectedIndex());
		panel.contenedor.removeAll();
		panel.contenedor.revalidate();
		panel.contenedor.repaint();
		panel.listar();
	}

}