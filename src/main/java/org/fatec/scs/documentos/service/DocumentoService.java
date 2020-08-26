package org.fatec.scs.documentos.service;

import java.util.stream.Collectors;

import org.fatec.scs.documentos.dto.DocumentoDTO;
import org.fatec.scs.documentos.dto.PastaDTO;
import org.fatec.scs.documentos.enums.FormatoDocumento;
import org.fatec.scs.documentos.model.Documento;
import org.fatec.scs.documentos.model.Pasta;
import org.fatec.scs.documentos.model.Pessoa;
import org.fatec.scs.documentos.repository.DocumentoRepository;
import org.fatec.scs.documentos.repository.PastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private PastaRepository pastaRepository;
	
	@Autowired
	private WebClient webClient;
	
	public Mono<Pasta> criaNovaPasta(PastaDTO pastaDTO){
		return Flux.fromIterable(pastaDTO.emails())
			.flatMap(email -> buscaPorEmail(email))
			.map(pessoa -> pessoa.getId())
			.collect(Collectors.toList())
			.flatMap(listaMembros -> pastaRepository.save(new Pasta(pastaDTO.nome(), pastaDTO.idAdministrador(), listaMembros)));
	}

	public Mono<Pasta> salvarDocumento(DocumentoDTO documentoDto) {
		return documentoRepository.save(new Documento(documentoDto.arquivo(), FormatoDocumento.valueOf(documentoDto.formato())))
			.flatMap(documento -> pastaRepository.findById(documentoDto.idPasta()).flatMap(pasta -> pastaRepository.save(pasta.addDocumento(documento.getId()))));
	}
	
	private Mono<Pessoa> buscaPorEmail(String email){
		return this.webClient
				.get()
				.uri("/email/{email}", email)
				.retrieve()
				.bodyToMono(Pessoa.class);
	}
}
