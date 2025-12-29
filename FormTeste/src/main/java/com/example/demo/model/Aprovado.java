package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Aprovado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @Column(length = 2000)
    private String concursos;

    private String imagemPath;

    public Aprovado() {}

    public Aprovado(String nome, String email, String telefone, String concursos, String imagemPath) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.concursos = concursos;
        this.imagemPath = imagemPath;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getConcursos() { return concursos; }
    public String getImagemPath() { return imagemPath; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setConcursos(String concursos) { this.concursos = concursos; }
    public void setImagemPath(String imagemPath) { this.imagemPath = imagemPath; }
}
