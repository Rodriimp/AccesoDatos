package ej02.services;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ej02.modelo.Cliente;

@RestController
public class ClientesServiceRest {

	@GetMapping("/clientes")
	public Cliente getClientes(@RequestParam String email) throws ClientesNotFoundException {

		ClientesService cService = new ClientesService();
		Cliente c = new Cliente();
		
		try {
			Map<String, Cliente> mapaClientes = cService.getMapaClientes();
			c = mapaClientes.get(email);
			if (c == null) {
				throw new ClientesNotFoundException("No existe ningun cliente con ese email");
			}

		} catch (ClientesServiceException e) {
			e.printStackTrace();
		}
		return c;

	}

}
