package com.fiap.grupo.dois.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.grupo.dois.dto.CoordenadorDTO;
import com.fiap.grupo.dois.error.ProfessorNotFoundException;
import com.fiap.grupo.dois.service.CoordenadorService;

@RestController
@RequestMapping("/api/coordenador")
public class CoordenadorController {
	
	private final CoordenadorService service;
	 
    @Autowired
    CoordenadorController(CoordenadorService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    CoordenadorDTO create(@RequestBody @Valid CoordenadorDTO coordenadorEntry) {
        return service.create(coordenadorEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    CoordenadorDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<CoordenadorDTO> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    CoordenadorDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    CoordenadorDTO update(@RequestBody @Valid CoordenadorDTO todoEntry) {
        return service.update(todoEntry);
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(ProfessorNotFoundException ex) {
    }
}
