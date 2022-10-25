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

import bra.edu.ifsp.artinstudies.model.Playlist;
import bra.edu.ifsp.artinstudies.repository.PlaylistRepository;

@CrossOrigin
@RestController
public class PlaylistController {
@Autowired
PlaylistRepository repo;
    // método GET
    @GetMapping("/playlist")
    public List<Playlist> listaPlaylists() {
        return (List<Playlist>) repo.findAll();

    }

    // método GET por ID
    @GetMapping("/playlist/{id}")
    public Optional<Playlist> RecuperaPlaylistPeloId(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    //método DELETE

    @DeleteMapping("/deletarPlaylist/{id}")
    public void DeletarPlaylistPeloId(@PathVariable("id") Long id) {
        repo.deleteById(id);
        
    }

    // método POST

    @PostMapping("/playlist")
    public void addPlaylist(@RequestBody Playlist playlist) {
        repo.save(playlist);
    }
}
