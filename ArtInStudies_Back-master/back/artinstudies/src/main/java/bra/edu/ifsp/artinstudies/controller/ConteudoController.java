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

import bra.edu.ifsp.artinstudies.model.Conteudo;
import bra.edu.ifsp.artinstudies.repository.ConteudoRepository;

@CrossOrigin
@RestController
public class ConteudoController {
    @Autowired
    ConteudoRepository repo;

    // método GET
    @GetMapping("/conteudo")
    public List<Conteudo> listaConteudos() {
        return (List<Conteudo>) repo.findAll();

    }

    // método GET por ID
    @GetMapping("/conteudo/{id}")
    public Optional<Conteudo> RecuperaConteudoPeloId(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    // método DELETE

    @DeleteMapping("/deletarConteudo/{id}")
    public void DeletarConteudoPeloId(@PathVariable("id") Long id) {
        repo.deleteById(id);

    }

    // método POST

    @PostMapping("/conteudo")
    public void addConteudo(@RequestBody Conteudo conteudo) {
        repo.save(conteudo);
    }
}