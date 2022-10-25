package bra.edu.ifsp.artinstudies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import bra.edu.ifsp.artinstudies.model.Usuario;
import bra.edu.ifsp.artinstudies.repository.UsuarioRepository;
import bra.edu.ifsp.artinstudies.security.jwt.JwtUtils;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody Usuario usuarioNovo){
        // Se encontrar no banco, não poderá criar um novo usuário
        boolean exists = userRepository.findByUsername(usuarioNovo.getNome()).stream().count() > 0;
        // Mas não existir, cra o novo usuário no banco
        if(!exists){
            //criptografa a senha do usuário para por no banco de dados
            usuarioNovo.setSenha(
                passwordEncoder.encode(usuarioNovo.getSenha())
            );
            userRepository.save(usuarioNovo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();    
    }

    @GetMapping("/user")
    public List<Usuario> getAllUsers(){
        return (List<Usuario>)userRepository.findAll();
    }
    
    @GetMapping("/user/me")
    public Usuario getMyInformations(@RequestHeader("Authorization") String token){
        // String token = headers.firstValue("Authorization").get();
        System.out.println(token);
        token = token.substring(7, token.length());
        String username = jwtUtils.getUserNameFromJwtToken(token);
        return userRepository.findByUsername(username).get(0);
    }
}
