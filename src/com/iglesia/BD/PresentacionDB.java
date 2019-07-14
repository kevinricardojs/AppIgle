package com.iglesia.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.iglesia.model.Presentacion;

public class PresentacionDB extends ConexionDB{
	Presentacion p;
	
	public PresentacionDB(Presentacion p) {
		this.p = p;
		System.out.println(this.p.getFecha());
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
			JOptionPane.showMessageDialog(null, "Verifique los datos!", "Error de registro",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
