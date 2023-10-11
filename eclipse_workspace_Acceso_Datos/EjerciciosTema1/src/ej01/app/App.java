package ej01.app;

import java.util.List;

import ej01.modelo.Pelicula;
import ej01.services.PeliculasServiceException;
import ej01.services.PeliculasServices;

public class App {

	public static void main(String[] args) {

		PeliculasServices pService = new PeliculasServices();

		try {
			List<Pelicula> peliculas = pService.getPeliculasMenor100min();

			for (Pelicula pelicula : peliculas) {
				System.out.println(pelicula);
			}
		} catch (PeliculasServiceException e) {
			e.printStackTrace();
		}
	}

}
