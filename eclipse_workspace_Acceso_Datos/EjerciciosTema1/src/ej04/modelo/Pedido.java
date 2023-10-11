package ej04.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Long idPedido;
	private LocalDate fechaPedido;
	private LocalDate fechaEntrega;
	private String cliente;
	private List<LineaPedido> lineasPed;

	public Pedido() {
		lineasPed = new ArrayList<LineaPedido>();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<LineaPedido> getLineasPed() {
		return lineasPed;
	}

	public void setLineasPed(List<LineaPedido> lineasPed) {
		this.lineasPed = lineasPed;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega
				+ ", cliente=" + cliente + ", lineasPed=" + lineasPed + "]";
	}

}
