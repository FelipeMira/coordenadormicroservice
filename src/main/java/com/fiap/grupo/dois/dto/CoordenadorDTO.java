package com.fiap.grupo.dois.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fiap.grupo.dois.model.Coordenador;

@SuppressWarnings("deprecation")
public class CoordenadorDTO {
	
	private String id;

    @Size(max = Coordenador.MAX_LENGTH_EMAIL)
    private String email;

    @NotEmpty
    @Size(max = Coordenador.MAX_LENGTH_NOME)
    private String nome;
    
    @NotEmpty
    @Size(max = Coordenador.MAX_LENGTH_TELEPHONE)
    private String telefone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "AlunoDTO [id=" + id + ", email=" + email + ", nome=" + nome + ", telefone=" + telefone + "]";
	}
}
