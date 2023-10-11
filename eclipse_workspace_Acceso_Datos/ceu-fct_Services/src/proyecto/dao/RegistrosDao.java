package proyecto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.modelo.Registro;

public class RegistrosDao {
	public List<Registro> consultarRegistro(Connection conn, Long idUsuario) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		List<Registro> registros = new ArrayList<Registro>();

		try {
			String sql = "Select * from registros where id_usuario= " + idUsuario;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Registro r = new Registro();

				r.setId_registro(rs.getLong("id_registro"));
				r.setId_usuario(rs.getLong("id_usuario"));
				r.setFecha(rs.getDate("fecha"));
				r.setNum_horas(rs.getBigDecimal("num_horas"));
				r.setDescripcion(rs.getString("descripcion"));
			}

			return registros;

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}

	}
}