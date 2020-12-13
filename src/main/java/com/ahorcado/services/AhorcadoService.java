package com.ahorcado.services;


import com.ahorcado.modelo.Jugador;
import com.ahorcado.modelo.Partida;

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
	public StringBuilder adivinarLetra(char introduccion) {
		if(contieneLetra(introduccion, partida.getPalabraSecreta())) {
			partida.setPalabraGuiones(exponGuiones(introduccion, partida.getPalabraSecreta()));
			jugador.setIntentos(jugador.getIntentos()+1);
		}else {
			jugador.setIntentosFallidos(jugador.getIntentosFallidos()+1);
		}
		return partida.getPalabraGuiones();
	}
	
	/* Introducimos palabra, si la adivinamos devolvemos true, si no aumentamos numero fallos */
	public boolean adivinarPalabra(String palabra) {
		boolean ganado = false;
		if(compruebaPalabra(palabra, partida.getPalabraSecreta())) {
			ganado = true;
		}else {
			jugador.setIntentosFallidos(jugador.getIntentosFallidos()+1);
		}
		return ganado;
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
	private StringBuilder exponGuiones(char letra, String palabra){
		StringBuilder nueva = new StringBuilder("");
		char[] arrayletras = palabra.toCharArray();
		for(int i=0 ; i<palabra.length(); i++) {
			if(letra == arrayletras[i]) {
				nueva.append(letra);
			}else {
				nueva.append("_");
			}
		}
		return nueva;
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
