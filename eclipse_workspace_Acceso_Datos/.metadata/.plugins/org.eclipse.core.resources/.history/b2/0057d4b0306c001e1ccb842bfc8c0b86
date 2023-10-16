package proyecto.app;

import proyecto.modelo.Usuario;
import proyecto.services.UsuariosService;

public class Test {

	public static void main(String[] args) {
		UsuariosService userService = new UsuariosService();

		Usuario user = new Usuario();
		user.setEmail("hola@gmail.com");
		user.setPassword("12345");
		user.setNombre("Rodri");
		user.setApellidos("Moreno Palacios");
		user.setCiclo("DAM");
		user.setActivo(true);

		try {
			userService.login(user.getEmail(), user.getPassword());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
