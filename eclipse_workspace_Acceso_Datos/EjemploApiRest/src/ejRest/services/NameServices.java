package ejRest.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NameServices {

	@GetMapping("/name")
	public String getNombre() {
		return "Jude Bellingham futuro Balon de Oro";
	}

	@GetMapping("/cuadrado")
	public Integer cuadrado(@RequestParam Integer num,@RequestParam Integer num2 ) {
		return num * num;
	}
	
	@GetMapping("/potencia/{num}/{num2} ")
	public Double potencia(@PathVariable Double num,@PathVariable Double num2 ) {
		return Math.pow(num, num2);
	}
}
