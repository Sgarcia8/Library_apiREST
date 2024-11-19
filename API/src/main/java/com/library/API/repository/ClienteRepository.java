package com.library.API.repository;

import com.library.API.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findBycorreo(String correo);
    Boolean existsBycorreo(String correo);
}
