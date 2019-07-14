package com.iglesia.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.iglesia.model.Persona;


public class PersonaDB extends ConexionDB{
	Persona p;
	
	public PersonaDB(Persona p) {
		this.p = p;
	}
	
	public boolean insert() {
		try {
			Connection conn = (Connection) this.conectar();
			String insercion = "INSERT INTO persona(nombres, apellidos, dpi, sexo, direccion, tel_casa, cel, tel_empresa, estado_civil, fecha_nacimiento, fecha_cristiano, fecha_bautizo, fecha_asistir, activo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			doInsercion.setString(12, p.getFechaBautizo());
			doInsercion.setString(13, p.getFechaAsistir());
			doInsercion.setInt(14, p.getActivo());
			
			doInsercion.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
			return true;
			
		}catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "DPI duplicado!", "Error de registro",JOptionPane.ERROR_MESSAGE);
			return false;
			
		}
		
	}
}
