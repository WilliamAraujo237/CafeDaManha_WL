package com.cafe.da.manha.Cafe.DTO;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class RegistroComidaColaboradorDTO {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(length = 11)
    private Double cpf;
    private String comida;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    //construtor vazio
    public RegistroComidaColaboradorDTO() {

    }

    //construtor com todos os atributos
    public RegistroComidaColaboradorDTO(Long id, String nome, Double cpf, String comida, Date data) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.comida = comida;
        this.data = data;
    }
    //Get e Set
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

    public Double getCpf() {
        return cpf;
    }

    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
