package br.gov.pa.iec.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.pa.iec.cursomc.model.Categoria;
import br.gov.pa.iec.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(final String[] args) {

        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {

        final Categoria cat1 = new Categoria(null, "Informática");
        final Categoria cat2 = new Categoria(null, "Escritório");

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
    }

}
