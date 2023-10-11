package ej02.services;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ej02.dao.ClientesDao;
import ej02.modelo.Cliente;

public class ClientesService {

	public Map<String, Cliente> getMapaClientes() throws ClientesServiceException {

		Connection conn = null;
		Map<String, Cliente> mapaCl = new HashMap<>();

		try {
			conn = new OpenConnection().abrirConexion();

			ClientesDao dao = new ClientesDao();

			List<Cliente> lista = dao.consultarClientes(conn);

			for (Cliente c : lista) {
				mapaCl.put(c.getEmail(), c);
			}

			return mapaCl;

		} catch (Exception e) {
			throw new ClientesServiceException("Error al obtener peliculas de la bbdd", e);
		}

	}

}
