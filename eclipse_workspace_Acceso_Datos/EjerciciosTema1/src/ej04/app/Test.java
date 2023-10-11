package ej04.app;

import java.math.BigDecimal;
import java.time.LocalDate;


import ej04.modelo.LineaPedido;
import ej04.modelo.Pedido;
import ej04.services.PedidosService;
import ej04.services.PedidosServicesException;

public class Test {

	public static void main(String[] args) {
		Long idPedido = 100L;
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2023, 12, 1));
		pedido.setCliente("Laura Salmerón");

		for (int j = 1; j <= 3; j++) {
			LineaPedido linea = new LineaPedido();
			linea.setArticulo("Artículo " + j);
			linea.setPrecio(new BigDecimal(938));
			pedido.getLineasPed().add(linea);
		}

		PedidosService service = new PedidosService();
		try {
			service.registrarPedido(pedido);
		} catch (PedidosServicesException e) {
			e.printStackTrace();
		}
	}

}
