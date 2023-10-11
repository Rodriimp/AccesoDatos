package ej02.app;

import java.util.Map;
import java.util.Scanner;

import ej02.modelo.Cliente;
import ej02.services.ClientesService;
import ej02.services.ClientesServiceException;

public class Test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el email de la persona que deseas");
		String email = sc.nextLine();

		ClientesService cService = new ClientesService();
		
		try {
			Map<String, Cliente> mapa = cService.getMapaClientes();

			System.out.println(mapa.get(email));

		} catch (ClientesServiceException e) {
			e.printStackTrace();
		}

		sc.close();
	}

}
