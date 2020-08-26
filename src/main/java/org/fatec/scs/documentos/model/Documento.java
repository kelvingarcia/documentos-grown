package org.fatec.scs.documentos.model;

import org.fatec.scs.documentos.enums.FormatoDocumento;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Documento {
	
	@Id
	private String id;
	private byte[] arquivo;
	private FormatoDocumento formatoOriginal;
		
	public Documento() {
	}

	public Documento(byte[] arquivo, FormatoDocumento formatoOriginal) {
		this.arquivo = arquivo;
		this.formatoOriginal = formatoOriginal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public FormatoDocumento getFormatoOriginal() {
		return formatoOriginal;
	}

	public void setFormatoOriginal(FormatoDocumento formatoOriginal) {
		this.formatoOriginal = formatoOriginal;
	}
	
	
	
}
