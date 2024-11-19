package com.library.API.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    @Column
    private String titulo;
    @Column(name = "año_publicacion")
    private int añoPublicacion;
    @Column
    private Boolean disponibilidad;
    @Column
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "libro-prestamo",
            joinColumns = @JoinColumn(name = "libroId", referencedColumnName = "idLibro"),
            inverseJoinColumns = @JoinColumn(name = "prestamoId", referencedColumnName = "idPrestamo")
    )
    private List<Prestamo> librosPrestado;

    @ManyToOne
    @JoinColumn(name = "idAutor")
    @JsonBackReference("autor-libro")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    @JsonBackReference("categoria-libro")
    private Categoria categoria;
}
