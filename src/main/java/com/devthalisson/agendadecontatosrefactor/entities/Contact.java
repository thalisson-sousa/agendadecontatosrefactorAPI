package com.devthalisson.agendadecontatosrefactor.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private Integer contato;
    private String imgUrl;

    public Contact() {}

    public Contact(Long id, String nome, String sobrenome, Integer contato, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.contato = contato;
        this.imgUrl = imgUrl;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getContato() {
        return contato;
    }

    public void setContato(Integer contato) {
        this.contato = contato;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
