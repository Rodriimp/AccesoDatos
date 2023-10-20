package ej01.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ej01.modelo.Pelicula;

@RestController
public class PeliculasServiceRest {

	@GetMapping("/peliculasCortas")
	public List<Pelicula> getPeliculas() {

		PeliculasServices pService = new PeliculasServices();
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		try {
			listaPelis = pService.getPeliculasMenor100min();
		} catch (PeliculasServiceException e) {
			e.printStackTrace();
		}
		return listaPelis;

	}

	@GetMapping("/peliculasMenorQue") // NombreParametro?=
	public List<Pelicula> getPeliculasMenorQue(@RequestParam Integer longitud) throws PeliculasBadRequestException {

		PeliculasServices pService = new PeliculasServices();
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		try {
			if (longitud < 20 || longitud > 300) {
				throw new PeliculasBadRequestException("No existen peliculas con esa longitud");
			}
			listaPelis = pService.getPeliculasMenorQue(longitud);
		} catch (PeliculasServiceException e) {
			e.printStackTrace();
		}
		return listaPelis;

	}

}
