package com.api.desafioBackEnd.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate anoLancamento;
    private String sinopse;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "diretor")
    private Pessoa diretor;
    @ManyToMany(cascade= CascadeType.ALL)
    private List<Pessoa> elenco;

    public Filme() {

    }

    public Filme(Long id, String nome, LocalDate anoLancamento, String sinopse, Pessoa diretor, List<Pessoa> elenco) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.elenco = elenco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Pessoa getDiretor() {
        return diretor;
    }

    public void setDiretor(Pessoa diretor) {
        this.diretor = diretor;
    }

    public List<Pessoa> getElenco() {
        return elenco;
    }

    public void setElenco(List<Pessoa> elenco) {
        this.elenco = elenco;
    }


}
