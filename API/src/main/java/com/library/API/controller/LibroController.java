package com.library.API.controller;


import com.library.API.dto.LibroApiDTO;
import com.library.API.dto.LibroDTO;
import com.library.API.service.LibroApiService;
import com.library.API.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private LibroService libroService;
    private LibroApiService libroApiService;

    @PostMapping("/admin")
    public ResponseEntity<LibroDTO> createLibro(@RequestBody LibroDTO libroDTO) {
        LibroDTO savedLibro = libroService.createLibro(libroDTO);
        return new ResponseEntity<>(savedLibro, HttpStatus.CREATED);
    }

    @GetMapping("/public")
    public ResponseEntity<List<LibroDTO>> getAllLibros() {
        List<LibroDTO> libros = libroService.getAllLibros();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/public/{id}")
    public ResponseEntity<LibroDTO> getLibroById(@PathVariable("id") Long libroId) {
        LibroDTO libroDTO = libroService.getLibroById(libroId);
        return ResponseEntity.ok(libroDTO);
    }
    @GetMapping("/public/titulo/{titulo}")
    public ResponseEntity<?> getLibroByTitulo(@PathVariable("titulo") String titulo) {
        try {
            LibroDTO libroDTO = libroService.getLibroByTitulo(titulo);
            return ResponseEntity.ok(libroDTO);
        }catch (Exception e) {
            LibroApiDTO libroDTO = libroApiService.getLibroByTitle(titulo);
            return ResponseEntity.ok(libroDTO);

        }

    }

    @GetMapping("/public/autor/{id}")
    public ResponseEntity<List<LibroDTO>> getLibrosByAutor(@PathVariable("id") Long autorId) {
        List<LibroDTO> libros = libroService.getLibroByAutor(autorId);
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/public/categoria/{id}")
    public ResponseEntity<List<LibroDTO>> getLibrosByCategoria(@PathVariable("id") Long categoriaId) {
        List<LibroDTO> libros = libroService.getLibroByCategoria(categoriaId);
        return ResponseEntity.ok(libros);
    }

    @PostMapping("/admin/actualizar/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(@RequestBody LibroDTO libroDTO, @PathVariable("id") Long libroId) {
        libroDTO.setIdLibro(libroId);
        LibroDTO libroActu = libroService.updateLibro(libroDTO);
        return ResponseEntity.ok(libroActu);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable("id") Long libroId) {
        libroService.deleteLibro(libroId);
        return new ResponseEntity<>("Libro eliminado con exito!", HttpStatus.OK);
    }

}
