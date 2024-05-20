package com.modasby.testetecnico.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {

    public Endereco() {
        this.estado = "";
        this.cidade = "";
        this.logradouro = "";
        this.numero = 0;
        this.cep = "";
    }

    public Endereco(String estado, String cidade, String logradouro, int numero, String cep) {
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "varchar(2)")
    private String estado;

    @Column(columnDefinition = "varchar(100)")
    private String cidade;

    @Column(columnDefinition = "varchar(100)")
    private String logradouro;

    @Column
    private int numero;

    @Column(columnDefinition = "varchar(8)")
    private String cep;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
