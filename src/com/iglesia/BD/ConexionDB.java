package com.iglesia.BD;

import java.sql.*;

public class ConexionDB {

	public ConexionDB() {
		try {
			//1 Conexión
			Connection c =  DriverManager.getConnection("jdbc:sqlite:IglesiaLibro.db");
			
			System.out.println("Conexion con exito"  + c);
		} catch (Exception e) {
			System.out.println("Falló");
		}
	}
	
}
