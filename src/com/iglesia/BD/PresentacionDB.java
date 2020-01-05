package com.iglesia.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.iglesia.model.Presentacion;

public class PresentacionDB extends ConexionDB{
	Presentacion p;
	
	public PresentacionDB(Presentacion p) {
		this.p = p;
	}
	
	public boolean insert() {
		try {
			Connection conn = (Connection) this.conectar();
			String insercion = "INSERT INTO presentacion(padre_id, madre_id, ninio_id, fecha) values(?, ?, ?, ?)";
			PreparedStatement doInsercion = (PreparedStatement) conn.prepareStatement(insercion);
				
			doInsercion.setInt(1, p.getPadre());
			doInsercion.setInt(2, p.getMadre());
			doInsercion.setInt(3, p.getNinio());
			doInsercion.setString(4, p.getFecha());
			
			doInsercion.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Verifique los datos!", "Error de registro",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public static ResultSet all(){
		PresentacionDB p = new PresentacionDB(null);
		Statement doInsercion = null;
		try {
			Connection conn = p.conectar();
			String query = "SELECT pre.id_presentacion, CONCAT(pa.nombres, ', ', pa.apellidos) AS padre, CONCAT(ma.nombres, ', ', ma.apellidos) AS madre, CONCAT(hi.nombres, ', ', hi.apellidos) AS hijo, pre.fecha " + 
							"FROM presentacion AS pre LEFT JOIN persona AS pa ON pre.padre_id = pa.id LEFT JOIN persona AS ma ON pre.madre_id = ma.id LEFT JOIN persona AS hi ON pre.ninio_id = hi.id";
			 doInsercion = conn.createStatement();
			 ResultSet rs = doInsercion.executeQuery(query);
			return rs; 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
		
	}
	
	public static ResultSet verPresentacion(int id){
		PresentacionDB p = new PresentacionDB(null);
		Statement doInsercion = null;
		try {
			Connection conn = p.conectar();
			String query = "SELECT CONCAT(pa.nombres, ', ', pa.apellidos) AS padre, CONCAT(ma.nombres, ', ', ma.apellidos) AS madre, CONCAT(hi.nombres, ', ', hi.apellidos) AS hijo, pa.foto AS ftpadre, ma.foto AS ftmadre, hi.foto AS fthijo, pre.fecha FROM presentacion AS pre LEFT JOIN persona AS pa ON pre.padre_id = pa.id LEFT JOIN persona AS ma ON pre.madre_id = ma.id LEFT JOIN persona AS hi ON pre.ninio_id = hi.id where pre.id_presentacion = " + id;
			 doInsercion = conn.createStatement();
			 ResultSet rs = doInsercion.executeQuery(query);
			return rs; 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
		
	}
	
	public static boolean delete(int id) {
		PresentacionDB p = new PresentacionDB(null);
		Statement doInsercion = null;
		try {
			Connection conn = p.conectar();
			
			String query = "delete from presentacion where id_presentacion = ?";
			
			PreparedStatement borrar = (PreparedStatement) conn.prepareStatement(query);
			
			borrar.setInt(1, id);
			
			borrar.executeUpdate();
			
			return true; 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

}
