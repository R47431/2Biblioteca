package com.example.sistemaBiblioteca.global;

import java.util.Optional;

import com.example.sistemaBiblioteca.exception.NotEqualsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;



@Service
public class GlobalService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalService.class);

    public <T> T encontrarEntidadePorId(JpaRepository<T, Long> repositorio, Long id, String messagem) {
        if (id == null) {
            throw new NullPointerException("");
        }
        Optional<T> entidadeOptional = repositorio.findById(id);
        if (entidadeOptional.isEmpty()) {
            LOGGER.warn("Entidade não encontrada: {}", messagem);
        }
        return entidadeOptional.get();
    }
//TODO teste de usando != ives de .equals
    public <T> void verificarIgualdade(T valorEntidade, T valorComparacao) {
        if (valorEntidade != valorComparacao) {
            throw new NotEqualsException("");
        }
    }

}
