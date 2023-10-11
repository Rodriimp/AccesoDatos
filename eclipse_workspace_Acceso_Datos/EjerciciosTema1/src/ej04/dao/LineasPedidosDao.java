package ej04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ej04.modelo.LineaPedido;

public class LineasPedidosDao {

	public void insertarPedido(Connection conn, LineaPedido lp) throws SQLException {
		PreparedStatement stmt = null;

		try {

			String sql = "Insert into pedidos_lineas (id_pedido, numero_linea, articulo, precio) values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, lp.getIdPedido());
			stmt.setInt(2, lp.getNumeroLinea());
			stmt.setString(3, lp.getArticulo());
			stmt.setBigDecimal(4, lp.getPrecio());

			stmt.execute();

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}

	}
}
