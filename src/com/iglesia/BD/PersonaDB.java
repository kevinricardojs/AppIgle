package com.iglesia.BD;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.iglesia.model.Persona;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PersonaDB extends ConexionDB{
	
	public PersonaDB(Persona p) {
		insert(p);
	}
	
	public void insert(Persona p) {
		if(p.isValid()){
		try {
			Connection conn = (Connection) this.conectar();
			String insercion = "insert into persona(nombres, apellidos, dpi, sexo, direccion, tel_casa, cel, tel_empresa, estado_civil, fecha_nacimiento, fecha_cristiano, fotografia) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement doInsercion = (PreparedStatement) conn.prepareStatement(insercion);
			
			doInsercion.setString(1, p.getNombres());
			doInsercion.setString(2, p.getApellidos());
			doInsercion.setString(3, p.getDPI());
			doInsercion.setInt(4, p.getSexo());
			doInsercion.setString(5, p.getDireccion());
			doInsercion.setString(6, p.getTelCasa());
			doInsercion.setString(7, p.getCelular());
			doInsercion.setString(8, p.getTelEmpresa());
			doInsercion.setInt(9, p.getEstadoCivil());
			doInsercion.setString(10, p.getFechaNacimiento());
			doInsercion.setString(11, p.getFechaCristiano());
			doInsercion.setString(12, p.getFotografiaUrl());
			
			doInsercion.executeUpdate();
			//Statement stmt = (Statement) conn.createStatement();
			
			//stmt.executeUpdate("insert into persona(nombres, fecha) values('" + p.getNombres() + "' ,'" + p.getFechaNac() +"');");
			
			System.out.println("insercion completada");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
			System.out.println("insercion incompleta");
		}
		
		}
		else {
			JOptionPane.showMessageDialog(null, "Por favor rellena los parametros necesarios");
		}
	}
}
