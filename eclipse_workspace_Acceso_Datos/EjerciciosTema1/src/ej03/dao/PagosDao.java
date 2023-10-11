package ej03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ej03.modelo.Pago;

public class PagosDao {

	public List<Pago> consultarPagosCliente(Connection conn, Integer id_cliente) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<Pago> pagos = new ArrayList<Pago>();
			String sql = "SELECT * from payment where customer_id= " + id_cliente;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Pago p = new Pago();
				p.setFecha(rs.getDate("payment_date").toLocalDate());
				p.setImporte(rs.getBigDecimal("amount"));

				pagos.add(p);
			}

			return pagos;

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}

	}

}
