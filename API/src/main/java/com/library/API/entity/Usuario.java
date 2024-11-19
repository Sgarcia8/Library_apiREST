package com.library.API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column
    private String nombre;
    @Column(unique = true)
    private String correo;
    @Column
    private String contrasena;
    @Column
    private int telefono;
    @Column(name = "estado_cuenta")
    private Boolean estadoCuenta;
    @Column
    private String role;

    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;
}
