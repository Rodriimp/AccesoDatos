package ej02.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ej02.modelo.Cliente;

@RestController
public class ClientesServiceRest {

	@GetMapping("/clientes")
	public Map<String, Cliente> getClientes(@RequestParam Cliente c) {

		ClientesService cService = new ClientesService();
		try {
			Map<String, Cliente> mapaClientes = cService.getMapaClientes();
			Map<String, Cliente> mapaClientesEmail = new HashMap<String, Cliente>();
			
		} catch (ClientesServiceException e) {
			e.printStackTrace();
		}
		return null;

	}

}
