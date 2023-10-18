package ejRest.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ejRest.modelo.Deporte;

@RestController
public class DeporteService {

	@GetMapping("/deporte")
	public Deporte getDeporte() {
		Deporte d = new Deporte();
		d.setAficionados(5000);
		d.setId(2);
		d.setNombre("Futbol");
		return d;
	}
	
	@PostMapping("/deporte")
	public void crearDeporte(@RequestBody Deporte deporte) {
		System.out.println("creando deporte...");
		System.out.println(deporte);
		System.out.println("Deporte creado");
	}

}
