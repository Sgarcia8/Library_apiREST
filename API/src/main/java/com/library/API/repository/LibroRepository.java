package com.library.API.repository;

import com.library.API.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findByTitulo(String titulo);

    List<Libro> findByAutor_IdAutor( Long idAutor);

    List<Libro> findByCategoria_IdCategoria( Long idCategoria);

}
