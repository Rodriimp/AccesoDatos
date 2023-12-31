package proyecto.modelo;

import java.math.BigDecimal;
import java.sql.Date;

public class Registro {

	private Long idRegistro;
	private Long idUsuario;
	private Date fecha;
	private BigDecimal num_horas;
	private String descripcion;

	public Long getId_registro() {
		return idRegistro;
	}

	public void setId_registro(Long id_registro) {
		this.idRegistro = id_registro;
	}

	public Long getId_usuario() {
		return idUsuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.idUsuario = id_usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date date) {
		this.fecha = date;
	}

	public BigDecimal getNum_horas() {
		return num_horas;
	}

	public void setNum_horas(BigDecimal num_horas) {
		this.num_horas = num_horas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
