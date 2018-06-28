package com.fiap.grupo.dois.mongoDb;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.grupo.dois.dto.CoordenadorDTO;
import com.fiap.grupo.dois.error.ProfessorNotFoundException;
import com.fiap.grupo.dois.model.Coordenador;
import com.fiap.grupo.dois.repository.CoordenadorRepository;
import com.fiap.grupo.dois.service.CoordenadorService;

@Service
public final class MongoDBCoordenadorService implements CoordenadorService{
	
	private final CoordenadorRepository repository;
	 
    @Autowired
    MongoDBCoordenadorService(CoordenadorRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public CoordenadorDTO create(CoordenadorDTO professor) {
        Coordenador persisted = Coordenador.getBuilder()
                .nome(professor.getNome())
                .email(professor.getEmail())
                .telefone(professor.getTelefone())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }
 
    @Override
    public CoordenadorDTO delete(String id) {
        Coordenador deleted = findAlunoById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }
 
    @Override
    public List<CoordenadorDTO> findAll() {
        List<Coordenador> professorEntries = repository.findAll();
        return convertToDTOs(professorEntries);
    }
 
    private List<CoordenadorDTO> convertToDTOs(List<Coordenador> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
 
    @Override
    public CoordenadorDTO findById(String id) {
        Coordenador found = findAlunoById(id);
        return convertToDTO(found);
    }
 
    @Override
    public CoordenadorDTO update(CoordenadorDTO professor) {
        Coordenador updated = findAlunoById(professor.getId());
        updated.update(professor.getNome(), professor.getEmail(), professor.getTelefone());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }
 
    private Coordenador findAlunoById(String id) {
        Optional<Coordenador> result = repository.findById(id);
        return result.orElseThrow(() -> new ProfessorNotFoundException(id));
 
    }
 
    private CoordenadorDTO convertToDTO(Coordenador model) {
        CoordenadorDTO dto = new CoordenadorDTO();
 
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setTelefone(model.getTelefone());
 
        return dto;
    }
}
