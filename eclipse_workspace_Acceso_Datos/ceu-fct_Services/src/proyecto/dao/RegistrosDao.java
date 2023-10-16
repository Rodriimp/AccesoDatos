package proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

				registros.add(r);
			}

			return registros;

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}

	}

	public Boolean consultarFechaRegistro(Connection conn, Long idUsuario, LocalDate fecha) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		List<Registro> registros = new ArrayList<Registro>();

		try {
			String sql = "Select * from registros where id_usuario= '" + idUsuario + "' and fecha= '" + fecha + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Registro r = new Registro();

				r.setId_registro(rs.getLong("id_registro"));
				r.setId_usuario(rs.getLong("id_usuario"));
				r.setFecha(rs.getDate("fecha"));
				r.setNum_horas(rs.getBigDecimal("num_horas"));
				r.setDescripcion(rs.getString("descripcion"));

				registros.add(r);
			}

			if (registros.isEmpty()) {
				return true;
			} else {
				return false;
			}
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}

	}

	public void insertarRegistro(Connection conn, Registro registro) throws SQLException {
		PreparedStatement stmt = null;

		try {
			String sql = "Insert into registros (id_registro, id_usuario, fecha, num_horas, descripcion) values (?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, registro.getId_registro());
			stmt.setLong(2, registro.getId_usuario());
			stmt.setDate(3, registro.getFecha());
			stmt.setBigDecimal(4, registro.getNum_horas());
			stmt.setString(5, registro.getDescripcion());

			stmt.execute();


		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}
	}
}
