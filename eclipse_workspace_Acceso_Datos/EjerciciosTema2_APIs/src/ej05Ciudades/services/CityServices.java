package ej05Ciudades.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ej01.services.OpenConnection;
import ej05Ciudades.dao.CityDao;
import ej05Ciudades.modelo.City;

public class CityServices implements CityInterface {

	@Override
	public List<City> getCities(String filtroDescripcion) throws NotFoundException, SERVEREXCEPTION {

		Connection conn = null;

		try {
			conn = new OpenConnection().abrirConexion();

			CityDao dao = new CityDao();

			if (filtroDescripcion == null) {
				filtroDescripcion = "";
			}

			List<City> ciudades = dao.consultarCiudades(conn, filtroDescripcion);
			if (ciudades == null) {
				throw new NotFoundException("No existen ciudades");
			}
			return ciudades;

		} catch (SQLException e) {
			throw new SERVEREXCEPTION("Error al obtener ciudades de la bbdd", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

	}

	@Override
	public City getCity(Long id) throws NotFoundException, SERVEREXCEPTION {
		Connection conn = null;
		try {
			conn = new OpenConnection().abrirConexion();
			CityDao dao = new CityDao();
			City ciudad = dao.consultarCiudad(conn, id);

			if (ciudad == null) {
				throw new NotFoundException("No existe esa ciudad");

			}
			return ciudad;
		} catch (SQLException e) {
			throw new SERVEREXCEPTION("Error al obtener ciudades de la bbdd", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

	}

	@Override
	public City createCity(City city) throws SERVEREXCEPTION {
		Connection conn = null;
		try {
			conn = new OpenConnection().abrirConexion();
			CityDao dao = new CityDao();
			Long id = dao.crearCiudad(conn, city);
			city.setId(id);
			return city;

		} catch (SQLException e) {
			throw new SERVEREXCEPTION("Error al crear ciudades en la bbdd", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

	@Override
	public void updateCity(City city) throws NotFoundException, SERVEREXCEPTION {
		Connection conn = null;
		try {
			conn = new OpenConnection().abrirConexion();
			CityDao dao = new CityDao();

			if (dao.actualizarCiudad(conn, city) == 0) {
				throw new NotFoundException("No existe esa ciudad");
			}
		} catch (SQLException e) {
			throw new SERVEREXCEPTION("Error al obtener ciudades de la bbdd", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

	@Override
	public City updateSelectiveCity(City city) throws NotFoundException, SERVEREXCEPTION {
		Connection conn = null;
		try {
			conn = new OpenConnection().abrirConexion();
			CityDao dao = new CityDao();
			if (dao.actualizarSelectiveCiudad(conn, city) == 0) {
				throw new NotFoundException("No existe esa ciudad");
			}
			City c = dao.consultarCiudad(conn, city.getId());

			return c;

		} catch (SQLException e) {
			throw new SERVEREXCEPTION("Error al obtener ciudades de la bbdd", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

	@Override
	public void deleteCity(Long id) throws NotFoundException, SERVEREXCEPTION {
		Connection conn = null;

		try {
			conn = new OpenConnection().abrirConexion();
			CityDao dao = new CityDao();
			if (dao.borrarCiudad(conn, id) == 0) {
				throw new NotFoundException("No existe esa ciudad");
			}

		} catch (SQLException e) {
			throw new SERVEREXCEPTION("Error al obtener ciudades de la bbdd", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}
