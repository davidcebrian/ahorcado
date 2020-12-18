package com.ahorcado.modelo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ahorcado.modelo.Partida;

public interface PartidaRepository extends CrudRepository<Partida, Long>{
	
	public Partida findPartidaByIdPartida(Long idPartida);
	
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query(value="UPDATE User u set u.userName = :newUserName where u.idUsuario = :idUsuario")
//	public void updateUser(Long idUsuario, String newUserName);
}
