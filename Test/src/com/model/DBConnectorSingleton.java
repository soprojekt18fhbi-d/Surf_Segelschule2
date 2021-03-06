package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorSingleton { // Ben Kr�ncke

	private static Connection conn;

	static {
		try {

			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/SurfSegelcenter", "sa", "sa");

		} catch (/** ClassNotFoundException | **/
		SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return conn;
	}

	public static void closeCon() throws SQLException {
		conn.close();
	}

}
