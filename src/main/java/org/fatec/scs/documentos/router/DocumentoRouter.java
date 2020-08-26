package org.fatec.scs.documentos.router;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.fatec.scs.documentos.dto.DocumentoDTO;
import org.fatec.scs.documentos.dto.PastaDTO;
import org.fatec.scs.documentos.model.Pasta;
import org.fatec.scs.documentos.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Configuration
public class DocumentoRouter {

	@Autowired
	private DocumentoService documentoService;
	
	@Bean
	public RouterFunction<ServerResponse> routes(){
		return route()
		.POST("/documento", req -> 
			ok().body(req.bodyToMono(DocumentoDTO.class).flatMap(dto -> 
			documentoService.salvarDocumento(dto)),
			Pasta.class
		))
		.POST("/pasta", req ->
			ok().body(req.bodyToMono(PastaDTO.class).flatMap(dto ->
			documentoService.criaNovaPasta(dto)),
			Pasta.class
		))
		.GET("/teste", req -> ok().body(Mono.just("API funcionando"), String.class))
		.build();
	}
}
