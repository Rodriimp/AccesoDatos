package ejemplo1_servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemplo1_modelo.Actor;

public class ActoresServices {

	private OpenConnection openConnection;

	public ActoresServices() {
		openConnection = new OpenConnection();
	}

	public List<Actor> consultarActores() throws ActoresServiceException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Actor> lista = new ArrayList<Actor>();

		try {

			conn = openConnection.getConnection();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM ACTOR";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Actor actor = new Actor();

				actor.setNombre(rs.getString("first_name"));
				actor.setApellidos(rs.getString("last_name"));
				actor.setId(rs.getInt("actor_id"));

				lista.add(actor);
			}

			return lista;

		} catch (SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			throw new ActoresServiceException("Error al obtener actores de la bbdd", e);
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				stmt.close();
			} catch (Exception e) {
			}

		}
	}
}
