package proyecto.app;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import proyecto.modelo.Registro;
import proyecto.services.RegistrosService;

public class Test {

	public static void main(String[] args) {
		RegistrosService rService = new RegistrosService();
		Registro registro = new Registro();
		registro.setId_registro(1L);
		registro.setId_usuario(5L);
		registro.setFecha(Date.valueOf(LocalDate.now()));
		registro.setNum_horas(new BigDecimal(3.5));
		registro.setDescripcion("hola");

		try {
			rService.crearRegistro(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
