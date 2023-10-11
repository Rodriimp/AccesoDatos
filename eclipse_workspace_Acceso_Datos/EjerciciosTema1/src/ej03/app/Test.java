package ej03.app;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ej03.modelo.Pago;
import ej03.services.PagosServices;
import ej03.services.PagosServicesException;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el email de la persona que deseas");
		String email = sc.nextLine();

		PagosServices pService = new PagosServices();

		try {
			Map<String, List<Pago>> mapa = pService.getMapaPagosClientes();

			System.out.println(mapa.get(email));

		} catch (PagosServicesException e) {
			e.printStackTrace();
		}

		sc.close();
	}
}
