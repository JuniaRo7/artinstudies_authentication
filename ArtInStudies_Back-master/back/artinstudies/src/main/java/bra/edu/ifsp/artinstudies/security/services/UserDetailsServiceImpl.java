package bra.edu.ifsp.artinstudies.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bra.edu.ifsp.artinstudies.model.Usuario;
import bra.edu.ifsp.artinstudies.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Encontra um usuário no banco de dados
        Usuario user = userRepository.findByUsername(username).stream().findFirst().get();
        // Depois retorna um objeto UserDetailsImpl com base no usuário encontrado
        return new UserDetailsImpl(user);        
    } 
}
