package com.iglesia.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private Connection conn = null;

	public ConexionDB() {
		
	}

	public Connection conexion() {
		return this.conn;
	}

	public Connection conectar() {
		try {
			// db parameters
			String url       = "jdbc:mysql://localhost:3306/libroiglesia?autoReconnect=true&useSSL=false";
			String user      = "root";
			String password  = "Kevin.jimenez5745";

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
