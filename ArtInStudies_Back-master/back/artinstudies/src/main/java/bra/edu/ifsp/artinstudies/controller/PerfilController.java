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

import bra.edu.ifsp.artinstudies.model.Perfil;
import bra.edu.ifsp.artinstudies.repository.PerfilRepository;

@CrossOrigin
@RestController
public class PerfilController {
    @Autowired
    PerfilRepository repo;

    // método GET
    @GetMapping("/perfil")
    public List<Perfil> listaPerfils() {
        return (List<Perfil>) repo.findAll();

    }

    // método GET por ID
    @GetMapping("/perfil/{id}")
    public Optional<Perfil> RecuperaPerfilPeloId(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    // método DELETE

    @DeleteMapping("/deletarPerfil/{id}")
    public void DeletarPerfilPeloId(@PathVariable("id") Long id) {
        repo.deleteById(id);

    }

    // método POST

    @PostMapping("/Perfil")
    public void addPerfil(@RequestBody Perfil perfil) {
        repo.save(perfil);
    }
}