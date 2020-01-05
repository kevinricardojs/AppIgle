package com.iglesia.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	protected Connection conn = null;

	public ConexionDB() {
		conectar();
	}

	public Connection conexion() {
		return this.conn;
	}

	public Connection conectar() {
		try {
			// db parameters
//			String url = "jdbc:sqlite:DB/libroiglesia.db";
			String url = "jdbc:mariadb://localhost:3306/libroiglesia?autoReconnect=true&useSSL=false";
			
			String user = "root";
			String password = "Ig13D10s";
				
			conn = DriverManager.getConnection(url, user, password);
			return conn;

		} catch(SQLException e) {
			conn = null;
			System.out.println(e.getMessage());
			return conn;
		}/*
		finally {
			try{
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException ex){
				System.out.println(ex.getMessage());
			}
		*/
	}
	
	private void cerrarConexion() {
		try{
			if(conn != null) {
				conn.close();
			}
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
	
}
