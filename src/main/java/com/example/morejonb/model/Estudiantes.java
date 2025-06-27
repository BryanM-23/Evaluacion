package com.example.morejonb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "estudiantes")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Estudiantes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String cedula;

    private double califAsistencia;
    private double califDeberes;
    private double califTrabajos;
    private double califExamen;

    @Column(nullable = false)
    private double notaFinal;
}