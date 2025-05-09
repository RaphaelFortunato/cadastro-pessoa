package com.fortunadev.enity_crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", initialValue = 1, allocationSize = 1)
public class Pessoa {

    @Id
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "O nome deve ser informado")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres.")
    private String nome;

    @NotBlank(message = "Informar o email")
    private String email;

    @NotBlank(message = "Informar o WhatsApp")
    private String whatsapp;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Pessoa(String whatsapp, String email, String nome) {
        this.whatsapp = whatsapp;
        this.email = email;
        this.nome = nome;
    }

    public Pessoa() {
    }
}
