package proyecto.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import proyecto.dao.FechasDao;
import proyecto.modelo.Fecha;

public class FechasService {

	private OpenConnection connProvider;

	public FechasService() {
		this.connProvider = new OpenConnection();
	}

	public List<Fecha> consultarActuales() throws FctException {
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			FechasDao fDao = new FechasDao();
			fDao.consultarFechas(conn, null, null);

		} catch (SQLException e) {
			throw new FctException("Error al obtener datos del usuario de la bbdd", e);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}

		}
		return null;

	}
}
