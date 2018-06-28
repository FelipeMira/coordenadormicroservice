package com.fiap.grupo.dois.service;

import java.util.List;

import com.fiap.grupo.dois.dto.CoordenadorDTO;

public interface CoordenadorService {
	
	CoordenadorDTO create(CoordenadorDTO aluno);
	 
	CoordenadorDTO delete(String id);
 
    List<CoordenadorDTO> findAll();
 
    CoordenadorDTO findById(String id);
 
    CoordenadorDTO update(CoordenadorDTO aluno);
}
