package com.modasby.testetecnico;

import com.modasby.testetecnico.Entities.Pessoa;
import com.modasby.testetecnico.repository.PessoaRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("personBean")
@ViewScoped
public class PersonBean implements Serializable {
    private final PessoaRepository repository;

    private Pessoa novaPessoa;
    private List<Pessoa> pessoas;

    @PostConstruct
    public void init() {
        this.novaPessoa = new Pessoa();
        this.pessoas = repository.findAll();
    }

    @Inject
    public PersonBean(PessoaRepository repository) {
        this.repository = repository;
    }

    public void adicionarPessoa() {
        repository.save(novaPessoa);
        pessoas = repository.findAll();
    }

    public void editarPessoa() {
        repository.update(novaPessoa);
        pessoas = repository.findAll();

        novaPessoa = new Pessoa();
    }

    public void prepararEdicao(Pessoa pessoa) {
        novaPessoa = repository.findById(pessoa.getId());
    }

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public Pessoa getNovaPessoa() {
        return novaPessoa;
    }
}
