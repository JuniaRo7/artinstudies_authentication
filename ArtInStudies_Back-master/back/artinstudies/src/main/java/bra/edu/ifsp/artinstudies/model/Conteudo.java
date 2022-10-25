package bra.edu.ifsp.artinstudies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Conteudo {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data_cadastro, texto, titulo;
    @ManyToOne
    @JsonBackReference
    private Usuario usuario;

    public Conteudo() {

    }

    public Conteudo(Long id, String data_cadastro, String texto, String titulo) {
        this.id = id;
        this.data_cadastro = data_cadastro;
        this.texto = texto;
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

}
