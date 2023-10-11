package ejemplo1_servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

	public Connection getConnection() throws SQLException {
		String urlConexion = "jdbc:mariadb://localhost:3306/sakila";
		String claseDriver = "org.mariadb.jdbc.Driver";
		String usuario = "sakila";
		String password = "sakila";

		try {
			Class.forName(claseDriver);

		} catch (ClassNotFoundException e) {
			System.out.println("No se encuentra la clase del driver. Revisa tu configuración");
			throw new RuntimeException("No se encuentra la clase del driver");
		}
		
		Connection conn = DriverManager.getConnection(urlConexion, usuario, password);

		return conn;

	}

}
