package com.api.desafioBackEnd.models;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @ManyToMany(mappedBy = "elenco")
    private List<Filme> filmes;

    public Pessoa(){
    }

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
