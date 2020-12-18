package com.ahorcado.modelo.repo;

import org.springframework.data.repository.CrudRepository;

import com.ahorcado.modelo.Jugador;

public interface JugadorRepository extends CrudRepository<Jugador, Long>{
	
	public Jugador findJugadorByIdJugador(Long idJugador);
}
