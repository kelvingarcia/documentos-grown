package org.fatec.scs.documentos.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record PastaDTO(String idAdministrador, String nome, List<String> emails) {

}
