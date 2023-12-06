package com.devthalisson.agendadecontatosrefactor.dto;

import com.devthalisson.agendadecontatosrefactor.entities.Contact;

public class ContactDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private Integer contato;
    private String imgUrl;

    public ContactDTO(Long id, String nome, String sobrenome, Integer contato, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.contato = contato;
        this.imgUrl = imgUrl;
    }

    public ContactDTO(Contact entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.contato = entity.getContato();
        this.imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Integer getContato() {
        return contato;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
