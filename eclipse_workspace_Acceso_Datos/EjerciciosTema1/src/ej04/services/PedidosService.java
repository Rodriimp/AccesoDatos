package ej04.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ej04.dao.LineasPedidosDao;
import ej04.dao.PedidosDao;
import ej04.modelo.LineaPedido;
import ej04.modelo.Pedido;

public class PedidosService {

	private OpenConnection connProvider;

	public PedidosService() {
		this.connProvider = new OpenConnection();
	}

	public void registrarPedido(Pedido pedido) throws PedidosServicesException {
		PedidosDao daoPedido = new PedidosDao();
		LineasPedidosDao daoLinea = new LineasPedidosDao();
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			conn.setAutoCommit(false);
			// 1. Insertar los datos de la tabla pedido (los datos principales)
			daoPedido.insertarPedido(conn, pedido);
			// 2. Recorrer todas las líneas del pedido (pedido.getLineas()) ...for..
			List<LineaPedido> lineas = pedido.getLineasPed();
			int numLinea = 1;
			for (LineaPedido linea : lineas) {
				// 3. Para cada línea --> Insertar la línea en tabla pedidos_lineas
				linea.setIdPedido(pedido.getIdPedido());
				linea.setNumeroLinea(numLinea);
				daoLinea.insertarPedido(conn, linea);
				numLinea++;
			}
			conn.commit();
		} catch (SQLException e) {
			System.err.println("Error al registrar pedido");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.err.println("No se ha podido hacer rollback");
			}
			throw new PedidosServicesException("Error al registrar pedido", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}
}
