package br.gov.pa.iec.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.pa.iec.cursomc.model.Categoria;
import br.gov.pa.iec.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(final Integer id) {

        final Optional<Categoria> obj = this.repo.findById(id);
        return obj.orElse(null);

    }
}
