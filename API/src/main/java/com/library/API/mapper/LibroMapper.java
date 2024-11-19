package com.library.API.mapper;

import com.library.API.dto.LibroDTO;
import com.library.API.entity.Libro;

public class LibroMapper {

    public static LibroDTO mapToLibroDTO(Libro libro) {
        return new LibroDTO(
                libro.getIdLibro(),
                libro.getTitulo(),
                libro.getAñoPublicacion(),
                libro.getDisponibilidad(),
                libro.getDescripcion(),
                libro.getLibrosPrestado(),
                libro.getAutor(),
                libro.getCategoria()
        );
    }

    public static Libro mapToLibro(LibroDTO libroDTO) {
        return new Libro(
                libroDTO.getIdLibro(),
                libroDTO.getTitulo(),
                libroDTO.getAñoPublicacion(),
                libroDTO.getDisponibilidad(),
                libroDTO.getDescripcion(),
                libroDTO.getLibrosPrestado(),
                libroDTO.getAutor(),
                libroDTO.getCategoria()
        );
    }
}
