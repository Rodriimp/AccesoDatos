package ej05Ciudades.services;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ej05Ciudades.modelo.City;

@RestController
public class CityServicesRest {

	@GetMapping("/city")
	public List<City> getCities(@RequestParam(required = false) String filtroDescripcion)
			throws NotFoundException, SERVEREXCEPTION {
		CityServices cs = new CityServices();
		return cs.getCities(filtroDescripcion);
	}

	@GetMapping("/city/{id}")
	public City getCity(@PathVariable Long id) throws NotFoundException, SERVEREXCEPTION {
		CityServices cs = new CityServices();
		return cs.getCity(id);
	}

	@PostMapping("/city")
	public City createCity(@RequestBody City city) throws SERVEREXCEPTION {
		CityServices cs = new CityServices();
		return cs.createCity(city);
	}

	@PutMapping("/city")
	public void updateCity(@RequestBody City city) throws NotFoundException, SERVEREXCEPTION {
		CityServices cs = new CityServices();
		cs.updateCity(city);
	}

	@PatchMapping("/city")
	public City updateSelectiveCity(@RequestBody City city) throws NotFoundException, SERVEREXCEPTION {
		CityServices cs = new CityServices();
		return cs.updateSelectiveCity(city);
	}

	@DeleteMapping("/city/{id}")
	public void deleteCity(@PathVariable Long id) throws NotFoundException, SERVEREXCEPTION {
		CityServices cs = new CityServices();
		cs.deleteCity(id);
	}

}
