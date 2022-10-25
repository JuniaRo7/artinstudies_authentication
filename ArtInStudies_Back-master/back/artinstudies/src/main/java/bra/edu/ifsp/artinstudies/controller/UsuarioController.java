package bra.edu.ifsp.artinstudies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bra.edu.ifsp.artinstudies.model.Usuario;
import bra.edu.ifsp.artinstudies.repository.UsuarioRepository;

@CrossOrigin
@RestController
public class UsuarioController {
@Autowired
UsuarioRepository repo;
    // método GET
    @GetMapping("/usuario")
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) repo.findAll();

    }

    // método GET por ID
    @GetMapping("/usuario/{id}")
    public Optional<Usuario> RecuperaUsuarioPeloId(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    //método DELETE

    @DeleteMapping("/deletarUsuario/{id}")
    public void DeletarUsuarioPeloId(@PathVariable("id") Long id) {
        repo.deleteById(id);
        
    }

    // método POST

    @PostMapping("/usuario")
    public void addUsuario(@RequestBody Usuario usuario) {
        repo.save(usuario);
    }

    public String getPassword() {
        return null;
    }

    public String getUsername() {
        return null;
    }
}
