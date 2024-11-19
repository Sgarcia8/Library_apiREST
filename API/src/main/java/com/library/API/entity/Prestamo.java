package com.library.API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;
    @Column(name = "fecha_inicio_prestamos")
    private Date fechaInicioPrestamo;
    @Column(name = "fecha_fin_prestamo")
    private Date fechaFinPrestamo;

    @ManyToMany(mappedBy = "librosPrestado")
    private List<Libro> prestamosLibro;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
