package animales;

import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		Animal a = new Animal();
		a.setId(22);
		a.setColor("Rojo");
		a.setRaza("Perro");
		a.setFechaNac(LocalDate.now());
		System.out.println(a);
	}

}
