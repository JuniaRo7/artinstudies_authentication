package bra.edu.ifsp.artinstudies.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome, email, senha, data_cadastro;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario")
    @JsonManagedReference
    private List<Conteudo> conteudos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_perfil")
    @JsonManagedReference
    private Perfil perfil;

    public Usuario() {

    }

    public Usuario(Long id, String nome, String email, String senha, String data_cadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.data_cadastro = data_cadastro;
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

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
