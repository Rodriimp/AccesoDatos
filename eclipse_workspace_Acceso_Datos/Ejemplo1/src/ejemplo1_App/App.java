package ejemplo1_App;

import java.util.List;

import ejemplo1_modelo.Actor;
import ejemplo1_servicios.ActoresServiceException;
import ejemplo1_servicios.ActoresServices;

public class App {
	public static void main(String[] args) {
		ActoresServices service = new ActoresServices();
		List<Actor> actores;
		try {
			actores = service.consultarActores();
			for (Actor actor : actores) {
				System.out.println(actor);

			}
		} catch (ActoresServiceException e) {
			e.printStackTrace();
		}

	}
}