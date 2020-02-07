package com.iglesia.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.iglesia.model.Matrimonio;

public class MatrimonioDB extends ConexionDB{

		Matrimonio p;
		
		public MatrimonioDB(Matrimonio p) {
			this.p = p;
		}
		
		public boolean insert() throws SQLException {
			try {
				Connection conn = (Connection) this.conectar();
				conn.setAutoCommit(false);
				String insercion = "INSERT INTO matrimonio(esposo_id, esposa_id, fecha) values(?, ?, ?)";
				PreparedStatement doInsercion = (PreparedStatement) conn.prepareStatement(insercion);
				
				doInsercion.setInt(1, p.getEsposo());
				doInsercion.setInt(2, p.getEsposa());
				doInsercion.setString(3, p.getFecha());
				
				doInsercion.executeUpdate();
				
				String upesposo = "UPDATE persona SET estado_civil = 1  WHERE id = ?";
				PreparedStatement upEsp = (PreparedStatement) conn.prepareStatement(upesposo);
				upEsp.setInt(1, p.getEsposo());
				
				upEsp.executeUpdate();
				
				String upesposa = "UPDATE persona SET estado_civil = 1  WHERE id = ?";
				PreparedStatement upEspa = (PreparedStatement) conn.prepareStatement(upesposa);
				upEspa.setInt(1, p.getEsposa());
				
				upEspa.executeUpdate();
				conn.commit();
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				return true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Verifique los datos!", "Error de registro",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
	
		
		public static ResultSet busqueda(String consulta){
			MatrimonioDB p = new MatrimonioDB(null);
			Statement doInsercion = null;
			try {
				Connection conn = p.conectar();
				String query = "SELECT" +
						" matri.id, " +
						" esposo.nombres 'esposo_nombres', " +
						" esposo.apellidos 'esposo_apellidos', " +
						" esposa.nombres 'esposa_nombres', " +
						" esposa.apellidos 'esposa_apellidos', " +
						" matri.fecha " + 
						" from matrimonio AS matri " +
						" LEFT JOIN persona AS esposo ON matri.esposo_id = esposo.id " +
						" LEFT JOIN persona AS esposa ON matri.esposa_id = esposa.id " +
						" WHERE matri.esposo_id in " +  
						"( SELECT id FROM persona WHERE nombres LIKE ? AND estado_civil = 1 ) " + 
						" OR matri.esposa_id in " +
						" ( SELECT id FROM persona WHERE nombres LIKE ? AND estado_civil = 1 )";
				
				PreparedStatement statment = (PreparedStatement) conn.prepareStatement(query);
				statment.setString(1, "%" + consulta + "%");
				statment.setString(2, "%" + consulta + "%");
				
				ResultSet rs = statment.executeQuery();
				return rs; 
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return null;
			}
			
		}
		
		public static ResultSet verMatrimonio(int id){
			MatrimonioDB p = new MatrimonioDB(null);
			Statement doInsercion = null;
			try {
				Connection conn = p.conectar();
				String query = "SELECT matri.id, h.nombres AS 'hnombres', h.apellidos AS 'hapellidos', h.foto AS 'hfoto', m.nombres AS 'mnombres', m.apellidos AS 'mapellidos', m.foto AS 'mfoto',matri.fecha FROM matrimonio AS matri LEFT JOIN persona AS h ON h.id = matri.esposo_id LEFT JOIN persona AS m ON m.id = matri.esposa_id WHERE matri.id =" + id ;
				 doInsercion = conn.createStatement();
				 ResultSet rs = doInsercion.executeQuery(query);
				return rs; 
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return null;
			}
			
		}
		
		public static boolean delete(int id) {
			MatrimonioDB p = new MatrimonioDB(null);
			Statement doInsercion = null;
			try {
				Connection conn = p.conectar();
				
				String query = "delete from matrimonio where id = ?";
				
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
