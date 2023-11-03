package ej05Ciudades.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ej05Ciudades.modelo.City;

public class CityDao {

	public List<City> consultarCiudades(Connection conn, String filtro) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<City> ciudades = new ArrayList<City>();
			String sql = "SELECT * from city where city like '%" + filtro + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				City c = new City();
				c.setId(rs.getLong("city_id"));
				c.setDescripcion(rs.getString("city"));
				c.setCountryId(rs.getLong("country_id"));
				ciudades.add(c);

			}

			return ciudades;

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}

	}

	public City consultarCiudad(Connection conn, Long id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * from city where city_id = " + id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				City c = new City();
				c.setId(rs.getLong("city_id"));
				c.setDescripcion(rs.getString("city"));
				c.setCountryId(rs.getLong("country_id"));

				return c;
			} else {
				return null;
			}

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}

	}

	public Long crearCiudad(Connection conn, City c) throws SQLException {
		PreparedStatement stmt = null;

		try {

			String sql = "Insert into city (city, country_id) values (?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getDescripcion());
			stmt.setLong(2, c.getCountryId());

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}
	}

	public Integer actualizarCiudad(Connection conn, City c) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE city set city=? , country_id=? where city_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getDescripcion());
			stmt.setLong(2, c.getCountryId());
			stmt.setLong(3, c.getId());

			return stmt.executeUpdate();
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}
	}

	public Integer actualizarSelectiveCiudad(Connection conn, City c) throws SQLException {
		Statement stmt = null;
		try {
			String sql = "";
			if (c.getCountryId() == null) {
				sql = "UPDATE city set city='" + c.getDescripcion() + "' where city_id= " + c.getId();
			}
			if (c.getDescripcion() == null) {
				sql = "UPDATE city set country_id= " + c.getCountryId() + " where city_id= " + c.getId();
			}
			if (c.getCountryId() != null && c.getDescripcion() != null) {
				sql = "UPDATE city set country_id= " + c.getCountryId() + ", city= '" + c.getDescripcion()
						+ "' where city_id= " + c.getId();
			}

			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}
	}

	public Integer borrarCiudad(Connection conn, Long id) throws SQLException {
		Statement stmt = null;

		try {
			String sql = "DELETE FROM city WHERE city_id= " + id;
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}
	}

}
