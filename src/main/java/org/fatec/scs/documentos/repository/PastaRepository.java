package org.fatec.scs.documentos.repository;

import org.fatec.scs.documentos.model.Pasta;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PastaRepository extends ReactiveCrudRepository<Pasta, String> {
}
