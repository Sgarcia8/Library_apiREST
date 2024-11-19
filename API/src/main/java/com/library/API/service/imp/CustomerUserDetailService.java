package com.library.API.service.imp;

import com.library.API.entity.Usuario;
import com.library.API.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = clienteRepository.findBycorreo(correo).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));


        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_"+ usuario.getRole()))
        );
                //CustomerUserDetails(cliente);
    }
}
