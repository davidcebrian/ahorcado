package com.ahorcado.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Partida {
	private static final int MAX_ERRORES = 5;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPartida;
	
	@OneToMany(mappedBy = "partida")
	private List<Jugador> jugadores;
	private String palabraSecreta;
	private StringBuilder palabraGuiones;
	private boolean acertada;
	
	public Partida() {
		super();
		this.jugadores = new ArrayList<>();
	}
	public Partida(String palabraSecreta, StringBuilder palabraGuiones) {
		super();
		this.jugadores = new ArrayList<>();
		this.palabraSecreta = palabraSecreta;
		this.palabraGuiones = palabraGuiones;
		this.acertada = false;
	}
	public long getIdPartida() {
		return idPartida;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public String getPalabraSecreta() {
		return palabraSecreta;
	}
	public void setPalabraSecreta(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
	}
	public StringBuilder getPalabraGuiones() {
		return palabraGuiones;
	}
	public void setPalabraGuiones(StringBuilder palabraGuiones) {
		this.palabraGuiones = palabraGuiones;
	}
	public boolean isAcertada() {
		return acertada;
	}
	public void setAcertada(boolean acertada) {
		this.acertada = acertada;
	}
	public static int getMaxErroresPalabras() {
		return MAX_ERRORES;
	}
	
	
}
