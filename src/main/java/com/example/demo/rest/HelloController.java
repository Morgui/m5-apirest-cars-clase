package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller //cuando creamos un controlador de spring mvc, redireccionando plantillas del back al front
//@Component //anotación génerica para indicar que es un componente que debe ser inyectado y demas

//@RequestMapping("/api") // Enrutado HTTP //requestmapping a nivel de clase
@RestController  // más especializada y por defecto
public class HelloController {

	private final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/")
	public String index() {

		return "API REST is at /api/....";
	}
	/*
	 * http://localhost:8080/api/hello
	 * @return
	 */
	@GetMapping("/hello")
//	@PostMapping
//	@PutMapping
//	@DeleteMapping
	public String hello() {
//	log.debug("Executing hello world method"); por ahora no lo usamos porque hay que meter tb algo en application.properties
//	System.out.println("Executing hello world method from sysout"); con los log ya no usariamos los sysout
		
		log.info("Executing hello world method from logger");
		log.warn("Executing hello world method from logger");
		log.error("Executing hello world method from logger");

		return "Hola Mundo";
	}
	
	/**
	 * http://localhost:8080/api/hello
	 * @return
	 */
	@GetMapping("/api/bye")
	public String bye() {
		log.info("Executing bye world method from logger");
		// diferentes niveles de logger:
		// log.warn("Executing hello world method from logger");
		// log.error("Executing hello world method from logger");
		return "Adios mundo cruel";
	}
	
	
}
