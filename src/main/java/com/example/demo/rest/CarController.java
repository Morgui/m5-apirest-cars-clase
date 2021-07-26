package com.example.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Car;

@RestController
@RequestMapping("/api")
public class CarController {

	private final Logger log = LoggerFactory.getLogger(CarController.class);

	// find all
	/*
	 * http://localhost:8080/api/cars
	 * 
	 * @return
	 */
	@GetMapping("/cars")
	public List<Car> findAll() {
		log.info("Executing REST request to find all cars");
		Car car1 = new Car(1L, "Ford", "Mondeo", 1.5, 5);
		Car car2 = new Car(2L, "Kia", "Niro", 1.5, 5);
		return List.of(car1, car2);

	}

	// find one
	/*
	 * http://localhost:8080/api/cars/2
	 * 
	 * @return a response entity with car
	 */
	@GetMapping("/cars/{id}")
	// se puede poner tb @PathVariable("id")
	public ResponseEntity<Car> findOne(@PathVariable Long id) {
		log.info("Executing REST request to find one car");

		Car car2 = new Car(id, "Kia", "Niro", 1.5, 5); // al poner id se harcodea el coche el todos los ids que pongamos
		return ResponseEntity.ok(car2);
		// return ResponseEntity.ok().body(car2); es otra posibilidad pero el otro es
		// más sencillo?

	}

	// create one
	@PostMapping("/cars")
	public ResponseEntity<Car> create(@RequestBody Car car) {
		log.info("Executing REST request to create a new car");

		if (car.getId() != null) { // Hay ID - quiere decir que ya existe y no puedo crearlo
			log.warn("Trying to create a new car with existent id");
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(new Car(3L, "Rebault", "Captur", 1.5, 3));

		// Otra posibilidad de crearlo metiendo el id a cañon, esta es la que usa Alan
		// durante la clase
		// car.setId(3L);
		// return ResponseEntity.ok(car);
		// new Car("Renault", "Captur", 1.5, 3); son los datos que se meterian en
		// postman directamente para que funcione lo anterior
	}

	// update
	@PutMapping("/cars")
	public ResponseEntity<Car> update(@RequestBody Car car) {
		log.info("Executing REST request to update an existing car");

		if (car.getId() == null) { // no hay ID - quiere decir que no existe y no puedo actualizarlo
			log.warn("Trying to update a existing car without id");
			return ResponseEntity.badRequest().build();
		}
//		car.setManufacturer(car.getManufacturer() + " Editado");
		return ResponseEntity.ok(car);
	}

	// delete one
	@DeleteMapping("/cars/{id}")
	//se pone void porque sabemos que no va delvolver nada
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		log.info("Executing REST request to delte an existing car");

		// simular borrar de base de datos
		// deleteById(id)
		
		return ResponseEntity.noContent().build();

	}

	// delete all
	@DeleteMapping("/cars")
	//se pone void porque sabemos que no va delvolver nada
	public ResponseEntity<Car> deleteAll() {
		log.info("Executing REST request to delete all cars");

		// simular borrar de base de datos
		// deleteAll()
		
		return ResponseEntity.noContent().build();

	}
}
