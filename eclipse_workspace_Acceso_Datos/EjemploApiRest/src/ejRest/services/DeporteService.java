package ejRest.services;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejRest.modelo.Deporte;

@RestController
public class DeporteService {

	@GetMapping("/deporte")
	public Deporte getDeporte(@RequestParam Integer id) throws AccountNotFoundException, DeporteNotFoundException {
		Deporte d = new Deporte();
		d.setAficionados(5000);
		d.setId(id);
		if (id == 99) {
			throw new DeporteNotFoundException("No existe el deporte con id 99");
		}
		d.setNombre("Futbol");
		return d;
	}

	@PostMapping("/deporte")
	public Deporte crearDeporte(@RequestBody Deporte deporte) {
		System.out.println("creando deporte...");
		System.out.println(deporte);
		deporte.setId(99);
		System.out.println("Deporte creado");
		return deporte;
	}

}
