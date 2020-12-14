package com.ahorcado.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahorcado.services.AhorcadoService;

@RestController
@RequestMapping(path = "/ahorcado")
public class Controller {
	
	@Autowired
	private AhorcadoService servicio;

	@PostMapping("/{palabra}")
	public ResponseEntity<?> crearPartida(@PathVariable String palabra){
		servicio.crearPartida(palabra, "Jugador");
		return ResponseEntity.ok(servicio.damePalabra());
	}
	
	@PutMapping("/letra/{letra}")
	public ResponseEntity<?> enviarLetra(@PathVariable char letra){
		return ResponseEntity.ok(servicio.adivinarLetra(letra));
	}
	
	@PutMapping("/palabra/{palabra2}")
	public ResponseEntity<?> enviarPalabra(@PathVariable String palabra2){
		boolean ganado = servicio.adivinarPalabra(palabra2);
		return ResponseEntity.ok(ganado);
	}
	
	
}
