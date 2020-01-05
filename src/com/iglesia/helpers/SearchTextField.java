package com.iglesia.helpers;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.iglesia.BD.ConexionDB;

public class SearchTextField extends JTextField{
	JList lista;
	int tipo;

	public SearchTextField(JList lista, int tipo) {
		this.lista = lista;
		this.lista.setBackground(Color.white);
		this.tipo = tipo;
		eventos();
	}
	
	
	private void eventos() {
		this.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				prepararLista();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				prepararLista();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public ResultSet setLista(String texto, int genero) {
		ResultSet lista = null;
		try {
			String insercion;
			if(this.tipo == 0) {
				insercion = "SELECT id, nombres, apellidos FROM persona where nombres like ? and sexo = 0";
			}
			else if(this.tipo == 1){
				insercion = "SELECT id, nombres, apellidos FROM persona where nombres like ? AND sexo = 1";
			}
			else if(this.tipo == 3) {
				insercion = "SELECT id, nombres, apellidos FROM persona where nombres like ? AND sexo = 0 and estado_civil = 0";
			}
			else if(this.tipo == 4) {
				insercion = "SELECT id, nombres, apellidos FROM persona where nombres like ? AND sexo = 1 and estado_civil = 0";
			}
			else {
				insercion = "SELECT id, nombres, apellidos FROM persona where nombres like ?";
			}
			ConexionDB conexion = new ConexionDB();
			Connection conn = (Connection) conexion.conectar();
			
			PreparedStatement doInsercion = (PreparedStatement) conn.prepareStatement(insercion);
			
			doInsercion.setString(1, "%" + texto + "%");
			lista =  doInsercion.executeQuery();
			
			return lista;
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return lista;
		}
	}
	
	public void getLista() {
		this.lista.getSelectedIndex();
	}
	
	public void addLista(String[] l) {
		this.lista.setListData(l);
	}
	
	
	public String getWrited() {
		return this.getText();
	}


	public int getGenero() {
		return tipo;
	}


	public void setGenero(int tipo) {
		this.tipo = tipo;
	}
	
	public void prepararLista() {
		if (getWrited().length() > 3) {
			ResultSet lista = setLista(getWrited(), getGenero());
			ArrayList<String> l = new ArrayList<String>();
			if (lista != null) {
				try {
					while(lista.next()) {
						l.add(lista.getInt("id") + "- " + lista.getString("nombres") + " " + lista.getString("apellidos"));
					}
					
					String[] s = l.toArray(new String[0]);
					addLista(s);
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
