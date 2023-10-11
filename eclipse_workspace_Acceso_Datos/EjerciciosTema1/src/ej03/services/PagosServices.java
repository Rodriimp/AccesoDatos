package ej03.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ej02.dao.ClientesDao;
import ej02.modelo.Cliente;
import ej02.services.OpenConnection;
import ej03.dao.PagosDao;
import ej03.modelo.Pago;

public class PagosServices {

	public Map<String, List<Pago>> getMapaPagosClientes() throws PagosServicesException {

		Connection conn = null;
		List<Pago> listaPagos = new ArrayList<Pago>();
		Map<String, List<Pago>> mapaCl = new HashMap<>();

		try {
			conn = new OpenConnection().abrirConexion();

			ClientesDao cDao = new ClientesDao();
			List<Cliente> lista = cDao.consultarClientes(conn);
			PagosDao pDao = new PagosDao();

			for (Cliente c : lista) {
				listaPagos = pDao.consultarPagosCliente(conn, c.getId());
				mapaCl.put(c.getEmail(), listaPagos);
			}

			return mapaCl;

		} catch (Exception e) {
			throw new PagosServicesException("Error al obtener pagos de clientes de la bbdd", e);

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

}
