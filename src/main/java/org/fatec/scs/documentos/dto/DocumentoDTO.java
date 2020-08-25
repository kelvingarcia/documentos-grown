package org.fatec.scs.documentos.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record DocumentoDTO(String email, String formato) {
}
