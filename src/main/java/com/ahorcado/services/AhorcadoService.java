package com.ahorcado.services;


import org.springframework.stereotype.Service;

import com.ahorcado.modelo.Jugador;
import com.ahorcado.modelo.Partida;

@Service
public class AhorcadoService {
	
	Partida partida;
	Jugador jugador;
	
	/* Creamos la partida añadiendo la palabra que tenemos que adivinar y el nombre del jugador */
	public void crearPartida(String palabra, String nombre) {
		StringBuilder palabraGuion = inicio(palabra);
		partida = new Partida(palabra,palabraGuion);
		jugador = new Jugador(nombre);
		partida.getJugadores().add(jugador);
	}
	
	/* Introducimos una letra y si la palabra la contiene cambiamos la palbra con guiones a una con las letras descubiertas, si no aumentamos fallos */
	public String adivinarLetra(char introduccion) {
		String devuelve = "";
		if(contieneLetra(introduccion, partida.getPalabraSecreta())) {
			partida.setPalabraGuiones(exponGuiones(introduccion, partida.getPalabraSecreta(), partida.getPalabraGuiones()));
			jugador.setIntentos(jugador.getIntentos()+1);
		}else {
			jugador.setIntentosFallidos(jugador.getIntentosFallidos()+1);
		}
		if(jugador.getIntentosFallidos() >= partida.getMaxErroresPalabras()) {
			devuelve = "HAS PERDIDO :("+ 
					"\nLa palabra era " + partida.getPalabraSecreta();
		}else {
			devuelve = partida.getPalabraGuiones() + 
					"\n" + "Numero de intentos: " + jugador.getIntentos() + 
					"\n" + "Numero intentos fallidos: " + jugador.getIntentosFallidos();
		}
		return devuelve;
	}
	
	/* Introducimos palabra, si la adivinamos devolvemos true, si no aumentamos numero fallos */
	public String adivinarPalabra(String palabra) {
		boolean ganado = false;
		String devuelve = "";
		if(compruebaPalabra(palabra, partida.getPalabraSecreta())) {
			ganado = true;
			devuelve = partida.getPalabraSecreta() + "\nHAS GANADO!!";
		}else {
			jugador.setIntentosFallidos(jugador.getIntentosFallidos()+1);
		}
		if(jugador.getIntentosFallidos() >= partida.getMaxErroresPalabras()) {
			ganado = false;
			devuelve = "HAS PERDIDO :("+ 
					"\nLa palabra era " + partida.getPalabraSecreta();
		}
		return devuelve;
	}
	
	
	public StringBuilder damePalabra() {
		return partida.getPalabraGuiones();
	}
	//Otro service ???
	
	/* para iniciar la partida con una palabra con guiones para adivinar */
	private StringBuilder inicio(String palabra) {
		StringBuilder palabraGuion = new StringBuilder();
		for(int i=0; i<palabra.length(); i++) {
			palabraGuion.append("_");
		}
		return palabraGuion;
	}
	
	/* Introducimos una letra y vemos si la palabra contiene esa letra */
	private boolean contieneLetra(char letra, String palabra) {	
		boolean contiene = false;
		char[] arrayletras = palabra.toCharArray();
		for(char lett: arrayletras) {
			if(letra == lett) {
				contiene = true;
			}
		}
		return contiene;
	}
	
	/* sacamos una palabra con guiones nueva con las letras descubiertas que acertemos */
	private StringBuilder exponGuiones(char letr, String palabra, StringBuilder palabraguion){
		String letra = "" + letr;
		char[] arrayletras = palabra.toCharArray();
		for(int i=0 ; i<palabra.length(); i++) {
			if(letr == arrayletras[i]) {
				palabraguion.replace(i, i+1, letra);
			}else {
			}
		}
		return palabraguion;
	}
	
	/* Si las palabras son iguales devolvemos true*/
	private boolean compruebaPalabra(String palabra, String palabraAdivinar) {
		boolean contiene = false;
		if(palabra.equals(palabraAdivinar)) {
			contiene = true;
		}
		return contiene;
	}
	
	
	
}
