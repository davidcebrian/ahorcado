package com.ahorcado.services;

public class AhorcadoService {
	

	
	
	public String turno(String palabra, String adivinar) {
		String palabraGuion = inicio(palabra);
		if(adivinar.length() == 1) {
			char caracter = adivinar.
			if(contieneLetra(adivinar, palabra)) {
				
			}
		}
		return "";
	}
	
	
	
	
	
	public String inicio(String palabra) {
		String palabraGuion = "";
		for(int i=0; i<palabra.length(); i++) {
			palabraGuion = palabraGuion + "_";
		}
		return palabraGuion;
	}
	
	public boolean contieneLetra(char letra, String palabra) {	
		boolean contiene = false;
		char[] arrayletras = palabra.toCharArray();
	
		for(char lett: arrayletras) {
			if(letra == lett) {
				contiene = true;
			}
		}
		return contiene;
	}
	
	public boolean compruebaPalabra(String palabra, String palabraAdivinar) {
		boolean contiene = false;
		if(palabra.equals(palabraAdivinar)) {
			contiene = true;
		}
		return contiene;
	}
	
	
	
}
