package com.ahorcado.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@PostMapping("/palabra")
	public ResponseEntity<?> palabraAdivinar(@PathVariable String palabra){
		return ResponseEntity.ok(palabra);
	}
	
	
}
