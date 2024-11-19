package com.library.API.service.imp;

import com.library.API.dto.LibroDTO;
import com.library.API.entity.Libro;
import com.library.API.mapper.LibroMapper;
import com.library.API.repository.LibroRepository;
import com.library.API.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LibroServiceImpl implements LibroService {

    private LibroRepository libroRepository;

    @Override
    public LibroDTO createLibro(LibroDTO libroDTO) {

        Libro libro = LibroMapper.mapToLibro(libroDTO);
        Libro savedLibro = libroRepository.save(libro);

        return LibroMapper.mapToLibroDTO(savedLibro);
    }

    @Override
    public LibroDTO getLibroById(Long libroId) {
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new RuntimeException());
        return LibroMapper.mapToLibroDTO(libro);
    }

    @Override
    public LibroDTO getLibroByTitulo(String titulo) {
        Libro libro = libroRepository.findByTitulo(titulo);
        return LibroMapper.mapToLibroDTO(libro);
    }


    @Override
    public List<LibroDTO> getAllLibros() {
        List<Libro> libros = libroRepository.findAll();
        return libros.stream().map((libro)->LibroMapper.mapToLibroDTO(libro)).collect(Collectors.toList());
    }

    @Override
    public LibroDTO updateLibro(LibroDTO libro) {
        Libro libroM = LibroMapper.mapToLibro(libro);
        Libro savedLibro = libroRepository.save(libroM);
        return LibroMapper.mapToLibroDTO(savedLibro);
    }

    @Override
    public void deleteLibro(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        libroRepository.deleteById(id);
    }

    @Override
    public List<LibroDTO> getLibroByAutor(Long idAutor) {
        List<Libro> libros = libroRepository.findByAutor_IdAutor(idAutor);
        return libros.stream().map((libro)->LibroMapper.mapToLibroDTO(libro)).collect(Collectors.toList());
    }

    @Override
    public List<LibroDTO> getLibroByCategoria(Long idCategoria) {
        List<Libro> libros = libroRepository.findByCategoria_IdCategoria(idCategoria);
        return libros.stream().map((libro)->LibroMapper.mapToLibroDTO(libro)).collect(Collectors.toList());
    }
}
