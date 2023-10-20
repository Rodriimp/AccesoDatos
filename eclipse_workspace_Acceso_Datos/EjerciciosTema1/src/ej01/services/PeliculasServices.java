package ej01.services;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import ej01.dao.PeliculasDao;
import ej01.modelo.Pelicula;

public class PeliculasServices {

	public List<Pelicula> getPeliculasMenor100min() throws PeliculasServiceException {

		Connection conn = null;

		try {
			conn = new OpenConnection().abrirConexion();

			PeliculasDao dao = new PeliculasDao();

			List<Pelicula> peliculas = dao.consultarPeliculas(conn);

			Iterator<Pelicula> it = peliculas.iterator();
			while (it.hasNext()) {
				Pelicula i = it.next();
				if (i.getLongitud() > 100) {
					it.remove();
				}
			}

			return peliculas;

		} catch (Exception e) {
			throw new PeliculasServiceException("Error al obtener peliculas de la bbdd", e);
		}

	}
	
	public List<Pelicula> getPeliculasMenorQue(Integer longitud) throws PeliculasServiceException {

		Connection conn = null;

		try {
			conn = new OpenConnection().abrirConexion();

			PeliculasDao dao = new PeliculasDao();

			List<Pelicula> peliculas = dao.consultarPeliculas(conn);

			Iterator<Pelicula> it = peliculas.iterator();
			while (it.hasNext()) {
				Pelicula i = it.next();
				if (i.getLongitud() > longitud) {
					it.remove();
				}
			}

			return peliculas;

		} catch (Exception e) {
			throw new PeliculasServiceException("Error al obtener peliculas de la bbdd", e);
		}

	}
}
