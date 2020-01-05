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
	
	public boolean insert() throws SQLException {
		try {
			Connection conn = (Connection) this.conectar();
			conn.setAutoCommit(false);
			
			String persona = "INSERT INTO persona(nombres, apellidos, sexo, direccion, tel_casa, cel, tel_empresa, estado_civil, fecha_nacimiento, fecha_cristiano, fecha_bautizo, fecha_asistir, activo, foto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement doInsercion = (PreparedStatement) conn.prepareStatement(persona, Statement.RETURN_GENERATED_KEYS);
			
			doInsercion.setString(1, p.getNombres());
			doInsercion.setString(2, p.getApellidos());
			doInsercion.setInt(3, p.getSexo());
			doInsercion.setString(4, p.getDireccion());
			doInsercion.setString(5, p.getTelCasa());
			doInsercion.setString(6, p.getCelular());
			doInsercion.setString(7, p.getTelEmpresa());
			doInsercion.setInt(8, p.getEstadoCivil());
			doInsercion.setString(9, p.getFechaNacimiento());
			doInsercion.setString(10, p.getFechaCristiano());
			doInsercion.setString(11, p.getFechaBautizo());
			doInsercion.setString(12, p.getFechaAsistir());
			doInsercion.setInt(13, p.getActivo());
			
			doInsercion.setBinaryStream(14, new FileInputStream(p.getFoto()), (int)(p.getFoto().length()));
			
			doInsercion.executeUpdate();
			System.out.println(p.getDPI().length());
			
			if(p.getDPI().length() == 13) {
				ResultSet rs = doInsercion.getGeneratedKeys();
				
				int id_persona = 0;
				
				if(rs.next()) {
					id_persona = rs.getInt(1);
				}
				System.out.println(id_persona + " " + "id persona" + p.getDPI());
				
				String dpi = "INSERT INTO dpi(dpi, id_persona) values(?, ?)";
				PreparedStatement doDpi = (PreparedStatement) conn.prepareStatement(dpi);
				
				doDpi.setString(1, p.getDPI());
				doDpi.setInt(2, id_persona);
				
				doDpi.executeUpdate();
			}
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
			conn.commit();
			return true;
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error de registro", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null, "Registro Exitoso");
			//JOptionPane.showMessageDialog(null, "DPI duplicado!", "Error de registro",JOptionPane.ERROR_MESSAGE);
			conn.rollback();
			return false;
			
		}
		
	}
	
	
	public boolean update() throws SQLException {
		try {
			Connection conn = (Connection) this.conectar();
			conn.setAutoCommit(false);
			
			String persona = "UPDATE persona SET nombres = ? , apellidos = ?, sexo = ?, direccion = ?, tel_casa = ?, cel = ?, tel_empresa = ?, estado_civil = ?, fecha_nacimiento = ?, fecha_cristiano = ?, fecha_bautizo = ?, fecha_asistir = ?, activo = ? WHERE id = ?";
			PreparedStatement doInsercion = (PreparedStatement) conn.prepareStatement(persona, Statement.RETURN_GENERATED_KEYS);
			
			doInsercion.setString(1, p.getNombres());
			doInsercion.setString(2, p.getApellidos());
			doInsercion.setInt(3, p.getSexo());
			doInsercion.setString(4, p.getDireccion());
			doInsercion.setString(5, p.getTelCasa());
			doInsercion.setString(6, p.getCelular());
			doInsercion.setString(7, p.getTelEmpresa());
			doInsercion.setInt(8, p.getEstadoCivil());
			doInsercion.setString(9, p.getFechaNacimiento());
			doInsercion.setString(10, p.getFechaCristiano());
			doInsercion.setString(11, p.getFechaBautizo());
			doInsercion.setString(12, p.getFechaAsistir());
			doInsercion.setInt(13, p.getActivo());
			System.out.println(p.getActivo());
			//doInsercion.setBinaryStream(14, new FileInputStream(p.getFoto()), (int)(p.getFoto().length()));
			doInsercion.setInt(14, p.getId());
			
			doInsercion.executeUpdate();
			
			if(p.getDPI().length() == 13) {

				String dpi = "INSERT INTO dpi(dpi, id_persona) VALUES (?, ?) ON DUPLICATE KEY UPDATE dpi = ?, id_persona = ?";
				PreparedStatement doDpi = (PreparedStatement) conn.prepareStatement(dpi);
				
				doDpi.setString(1, p.getDPI());
				doDpi.setInt(2, p.getId());
				doDpi.setString(3, p.getDPI());
				doDpi.setInt(4, p.getId());
				
				doDpi.executeUpdate();
			}
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
			conn.commit();

			return true;
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error de registro", JOptionPane.ERROR_MESSAGE);
			//JOptionPane.showMessageDialog(null, "Registro Exitoso");
			//JOptionPane.showMessageDialog(null, "DPI duplicado!", "Error de registro",JOptionPane.ERROR_MESSAGE);
			conn.rollback();
			return false;
			
		}
		
	}
	
	public static ResultSet all(){
		PersonaDB p = new PersonaDB(null);
		Statement doInsercion = null;
		try {
			Connection conn = p.conectar();
			String query = "SELECT p.id, p.nombres, p.apellidos, p.cel, d.dpi FROM persona AS p LEFT JOIN dpi AS d ON p.id = d.id_persona";
			 doInsercion = conn.createStatement();
			 ResultSet rs = doInsercion.executeQuery(query);
			return rs; 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
		
	}
	
	public static ResultSet verPersona(int id_persona){
		PersonaDB p = new PersonaDB(null);
		Statement doInsercion = null;
		try {
			Connection conn = p.conectar();
			String query = "SELECT p.id, p.nombres, p.apellidos, p.direccion, p.foto, p.cel, p.tel_casa, p.tel_empresa, p.fecha_nacimiento, p.fecha_cristiano, p.fecha_bautizo, p.fecha_asistir, p.sexo, p.activo, p.estado_civil, d.dpi FROM persona AS p left JOIN dpi AS d ON p.id = d.id_persona WHERE p.id = '" + id_persona + "'";
			 doInsercion = conn.createStatement();
			 ResultSet rs = doInsercion.executeQuery(query);
			return rs; 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
		
	}
	
	public static boolean delete(int id_persona) {
		PersonaDB p = new PersonaDB(null);
		Statement doInsercion = null;
		try {
			Connection conn = p.conectar();
			
			String query = "delete from persona where id = ?";
			
			PreparedStatement borrar = (PreparedStatement) conn.prepareStatement(query);
			
			borrar.setInt(1, id_persona);
			
			borrar.executeUpdate();
			
			return true; 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
}
