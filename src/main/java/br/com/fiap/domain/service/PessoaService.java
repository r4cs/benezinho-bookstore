package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Pessoa;
import br.com.fiap.domain.repository.PessoaRepository;

import java.util.List;
import java.util.Objects;

public class PessoaService implements Service<Pessoa, Long> {

    private static volatile PessoaService instance;

    private PessoaRepository repo;

    private PessoaService(PessoaRepository repo) {
        this.repo = repo;
    }


    public static PessoaService of(PessoaRepository repo) {
        PessoaService result = instance;
        if (Objects.nonNull( result )) return result;

        synchronized (PessoaService.class) {
            if (Objects.isNull( instance )) {
                instance = new PessoaService( repo );
            }
            return instance;
        }
    }

    @Override
    public List<Pessoa> findAll() {
        return repo.findAll();
    }

    @Override
    public Pessoa findById(Long id) {
        return repo.findById( id );
    }


    @Override
    public List<Pessoa> findByName(String texto) {
        return repo.findByName( texto );
    }

    @Override
    public Pessoa persist(Pessoa book) {
        return repo.persist( book );
    }
}
