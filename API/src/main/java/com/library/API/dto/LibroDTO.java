package com.library.API.dto;

import com.library.API.entity.Autor;
import com.library.API.entity.Categoria;
import com.library.API.entity.Prestamo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO{
    private Long idLibro;
    private String titulo;
    private int añoPublicacion;
    private Boolean disponibilidad;
    private String descripcion;
    private List<Prestamo> librosPrestado;
    private Autor autor;
    private Categoria categoria;
}
