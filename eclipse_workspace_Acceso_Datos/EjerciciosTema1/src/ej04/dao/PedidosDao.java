package ej04.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ej04.modelo.Pedido;

public class PedidosDao {

	public Long insertarPedido(Connection conn, Pedido p) throws SQLException {
		PreparedStatement stmt = null;

		try {

			String sql = "Insert into pedidos (fecha_pedido, fecha_entrega, cliente) values (?,?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, Date.valueOf(p.getFechaPedido()));
			stmt.setDate(2, Date.valueOf(p.getFechaEntrega()));
			stmt.setString(3, p.getCliente());

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

}
