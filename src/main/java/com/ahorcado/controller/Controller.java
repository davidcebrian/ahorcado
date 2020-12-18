package com.ahorcado.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahorcado.services.AhorcadoService;

@RestController
@RequestMapping(path = "/ahorcado")
@CrossOrigin(origins = {"http://localhost:8080"})
public class Controller {
	
	@Autowired
	private AhorcadoService servicio;

	
	@PostMapping("/{palabra}")
	public ResponseEntity<?> crearPartida(@PathVariable String palabra){
		ResponseEntity<?> response = null;
		servicio.crearPartida(palabra, "Jugador");
		StringBuilder adivinar = servicio.damePalabra();
		if(adivinar != null) {
			response = ResponseEntity.ok(adivinar);
		}else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND ERROR");
		}
		return response;
	}
	
	@PutMapping("/letra/{letra}")
	public ResponseEntity<?> enviarLetra(@PathVariable char letra){
		ResponseEntity<?> response = null;
		String adivinar = servicio.adivinarLetra(letra);
		if(adivinar != null) {
			response = ResponseEntity.ok(adivinar);
		}else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND ERROR");
		}
		return response;
	}
	
	@PutMapping("/palabra/{palabra2}")
	public ResponseEntity<?> enviarPalabra(@PathVariable String palabra2){
		ResponseEntity<?> response = null;
		String adivinar = servicio.adivinarPalabra(palabra2);
		if(adivinar != null) {
			response = ResponseEntity.ok(adivinar);
		}else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND ERROR");
		}
		return response;
	}
	
	
}
