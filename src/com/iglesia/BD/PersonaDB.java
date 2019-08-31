package com.iglesia.BD;

import java.sql.Statement;
import java.io.InputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String insercion = "INSERT INTO persona(nombres, apellidos, dpi, sexo, direccion, tel_casa, cel, tel_empresa, estado_civil, fecha_nacimiento, fecha_cristiano, fecha_bautizo, fecha_asistir, activo, foto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			
			doInsercion.setBinaryStream(15, new FileInputStream(p.getFoto()), (int)(p.getFoto().length()));
			
			doInsercion.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
			return true;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
			JOptionPane.showMessageDialog(null, "DPI duplicado!", "Error de registro",JOptionPane.ERROR_MESSAGE);
			return false;
			
		}
		
	}
	
	
	public static ResultSet all(){
		PersonaDB p = new PersonaDB(null);
		Statement doInsercion = null;
		try {
			Connection conn = p.conectar();
			String query = "select * from persona";
			 doInsercion = conn.createStatement();
			 ResultSet rs = doInsercion.executeQuery(query);
			return rs; 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
}
