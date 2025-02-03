package com.estudo.userService.model;

public class User {
    
    private Long Id;
    
    private String Nome;
    
    private String Senha;

    public User() {}

    public User(Long id, String nome, String senha) {
        this.Id = id;
        this.Nome = nome;
        this.Senha = senha;
    }

    public Long getId() { return this.Id; }

    public void setId(Long id) { this.Id = id; }

    public String getNome() { return this.Nome; }

    public void setNome(String nome) { this.Nome = nome; }

    public String getSenha() { return this.Senha; }

    public void setSenha(String senha) { this.Senha = senha; }
}
