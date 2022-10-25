package bra.edu.ifsp.artinstudies.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bra.edu.ifsp.artinstudies.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
       List<Usuario> findByUsername(String username);

}