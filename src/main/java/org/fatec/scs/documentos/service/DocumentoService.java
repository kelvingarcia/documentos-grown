package org.fatec.scs.documentos.service;

import org.fatec.scs.documentos.dto.DocumentoDTO;
import org.fatec.scs.documentos.enums.FormatoDocumento;
import org.fatec.scs.documentos.model.Documento;
import org.fatec.scs.documentos.model.Pessoa;
import org.fatec.scs.documentos.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private WebClient webClient;

	public Mono<Documento> salvarDocumento(DocumentoDTO documentoDto) {
		return this.webClient
			.get()
			.uri("/email/{email}", documentoDto.email())
			.retrieve()
			.bodyToMono(Pessoa.class)
			.flatMap(pessoa -> documentoRepository.save(new Documento(pessoa.getId(), "email@solicitante", null,
				FormatoDocumento.valueOf(documentoDto.formato()))))
	        .onErrorMap(throwable -> new IllegalArgumentException("A exceção original foi " + throwable.toString()))
	        .onErrorResume(IllegalArgumentException.class, exception -> Mono.empty());
	}
}
