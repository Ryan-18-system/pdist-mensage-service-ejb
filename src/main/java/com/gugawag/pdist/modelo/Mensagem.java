package com.gugawag.pdist.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="tb_mensagem")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String texto;

    public Mensagem(String texto) {
        this.texto = texto;
    }

    public Mensagem(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Mensagem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                '}';
    }
}
