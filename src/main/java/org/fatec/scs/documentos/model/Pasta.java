package org.fatec.scs.documentos.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pasta {
	@Id
	private String id;
	private String nomePasta;
	private List<String> administradores = new ArrayList<>();
	private List<String> membros;
	private List<String> documentos = new ArrayList<>();
	
	public Pasta() {
	}

	public Pasta(String nomePasta, String admin, List<String> membros) {
		this.nomePasta = nomePasta;
		this.membros = membros;
		this.administradores.add(admin);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomePasta() {
		return nomePasta;
	}
	public void setNomePasta(String nomePasta) {
		this.nomePasta = nomePasta;
	}
	public List<String> getAdministradores() {
		return administradores;
	}
	public void setAdministradores(List<String> administradores) {
		this.administradores = administradores;
	}
	public List<String> getMembros() {
		return membros;
	}
	public void setMembros(List<String> membros) {
		this.membros = membros;
	}
	public List<String> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<String> documentos) {
		this.documentos = documentos;
	}
	
	public Pasta addDocumento(String documento) {
		this.documentos.add(documento);
		return this;
	}
	
}
