package com.iglesia.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.iglesia.model.Matrimonio;

public class MatrimonioDB extends ConexionDB{

		Matrimonio p;
		
		public MatrimonioDB(Matrimonio p) {
			this.p = p;
			System.out.println(this.p.getEsposa());
			System.out.println(this.p.getEsposo());
			System.out.println(this.p.getFecha());
		}
		
		public boolean insert() {
			try {
				Connection conn = (Connection) this.conectar();
				String insercion = "INSERT INTO matrimonio(esposo_id, esposa_id, fecha) values(?, ?, ?)";
				PreparedStatement doInsercion = (PreparedStatement) conn.prepareStatement(insercion);
				
				doInsercion.setInt(1, p.getEsposo());
				doInsercion.setInt(2, p.getEsposa());
				doInsercion.setString(3, p.getFecha());
				
				doInsercion.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				return true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "Verifique los datos!", "Error de registro",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
	

}
