package proyecto.modelo;

import java.sql.Date;

public class Fecha {

	private Date fecha;
	private Integer año;
	private Integer evaluacion;
	private Boolean disponibilidad;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

	public Integer getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Fechas [fecha=" + fecha + ", año=" + año + ", evaluacion=" + evaluacion + ", disponibilidad="
				+ disponibilidad + "]";
	}

}