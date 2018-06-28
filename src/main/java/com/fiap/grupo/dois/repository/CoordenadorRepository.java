package com.fiap.grupo.dois.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.fiap.grupo.dois.model.Coordenador;

public interface CoordenadorRepository extends Repository<Coordenador, String> {
	 
    void delete(Coordenador deleted);
    
    List<Coordenador> findAll();
 
    Optional<Coordenador> findById(String id);
 
    Coordenador save(Coordenador saved);
}
