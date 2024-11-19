package com.library.API.service;

import com.library.API.dto.LibroDTO;
import com.library.API.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroService {
    LibroDTO createLibro(LibroDTO libro);

    LibroDTO getLibroById(Long libroId);

    LibroDTO getLibroByTitulo(String titulo);

    List<LibroDTO> getAllLibros();

    LibroDTO updateLibro(LibroDTO libro);

    void deleteLibro(Long id);

    List<LibroDTO> getLibroByAutor(Long idAutor);

    List<LibroDTO> getLibroByCategoria(Long idCategoria);


}
