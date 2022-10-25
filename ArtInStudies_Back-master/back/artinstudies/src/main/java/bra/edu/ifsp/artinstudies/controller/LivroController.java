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

import bra.edu.ifsp.artinstudies.model.Livro;
import bra.edu.ifsp.artinstudies.repository.LivroRepository;

@CrossOrigin
@RestController
public class LivroController {
@Autowired
LivroRepository repo;
    // método GET
    @GetMapping("/livro")
    public List<Livro> listaLivros() {
        return (List<Livro>) repo.findAll();

    }

    // método GET por ID
    @GetMapping("/livro/{id}")
    public Optional<Livro> RecuperaLivroPeloId(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    //método DELETE

    @DeleteMapping("/deletarLivro/{id}")
    public void DeletarLivroPeloId(@PathVariable("id") Long id) {
        repo.deleteById(id);
        
    }

    // método POST

    @PostMapping("/livro")
    public void addLivro(@RequestBody Livro livro) {
        repo.save(livro);
    }
}
