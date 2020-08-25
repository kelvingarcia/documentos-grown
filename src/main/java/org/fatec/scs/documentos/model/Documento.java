package org.fatec.scs.documentos.model;

import org.fatec.scs.documentos.enums.FormatoDocumento;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Documento {
	
	@Id
	private String id;
	private String idPortador;
	private String idSolicitante;
	private byte[] documento;
	private FormatoDocumento formatoOriginal;
		
	public Documento() {
	}

	public Documento(String idPortador, String idSolicitante, byte[] documento, FormatoDocumento formatoOriginal) {
		this.idPortador = idPortador;
		this.idSolicitante = idSolicitante;
		this.documento = documento;
		this.formatoOriginal = formatoOriginal;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public FormatoDocumento getFormatoOriginal() {
		return formatoOriginal;
	}
	public void setFormatoOriginal(FormatoDocumento formatoOriginal) {
		this.formatoOriginal = formatoOriginal;
	}
	public String getIdPortador() {
		return idPortador;
	}
	public void setIdPortador(String idPortador) {
		this.idPortador = idPortador;
	}
	public String getIdSolicitante() {
		return idSolicitante;
	}
	public void setIdSolicitante(String idSolicitante) {
		this.idSolicitante = idSolicitante;
	}
	public byte[] getDocumento() {
		return documento;
	}
	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}
	
	
}
