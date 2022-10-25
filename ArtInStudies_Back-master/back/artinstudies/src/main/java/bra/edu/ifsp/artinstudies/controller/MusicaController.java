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

import bra.edu.ifsp.artinstudies.model.Musica;
import bra.edu.ifsp.artinstudies.repository.MusicaRepository;

@CrossOrigin
@RestController
public class MusicaController {
@Autowired
MusicaRepository repo;
    // método GET
    @GetMapping("/musica")
    public List<Musica> listaMusicas() {
        return (List<Musica>) repo.findAll();

    }

    // método GET por ID
    @GetMapping("/musica/{id}")
    public Optional<Musica> RecuperaMusicaPeloId(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    //método DELETE

    @DeleteMapping("/deletarMusica/{id}")
    public void DeletarMusicaPeloId(@PathVariable("id") Long id) {
        repo.deleteById(id);
        
    }

    // método POST

    @PostMapping("/musica")
    public void addMusica(@RequestBody Musica musica) {
        repo.save(musica);
    }
}
