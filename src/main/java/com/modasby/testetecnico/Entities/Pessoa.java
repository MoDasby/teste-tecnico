package com.modasby.testetecnico.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

    public Pessoa() {
        this.nome = "";
        this.idade = 0;
        this.sexo = "";
        this.endereco = new Endereco();
    }

    public Pessoa(String nome, int idade, String sexo, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String nome;

    private int idade;

    private String sexo;

    @OneToOne
    @JoinColumn
    private Endereco endereco;

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getSexo() {
        return this.sexo;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void printAttributes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);
        if (endereco != null) {
            System.out.println("Estado: " + endereco.getEstado());
            System.out.println("Cidade: " + endereco.getCidade());
            System.out.println("Logradouro: " + endereco.getLogradouro());
            System.out.println("Número: " + endereco.getNumero());
            System.out.println("CEP: " + endereco.getCep());
        }
    }
}
