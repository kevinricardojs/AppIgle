package com.iglesia.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	Connection conn = null;

	public ConexionDB() {		
		
		try {
			// db parameters
			String url       = "jdbc:mysql://localhost:3306/libroiglesia?autoReconnect=true&useSSL=false";
			String user      = "root";
			String password  = "Kevin.jimenez5745";

			conn = DriverManager.getConnection(url, user, password);

		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try{
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
	}

}
