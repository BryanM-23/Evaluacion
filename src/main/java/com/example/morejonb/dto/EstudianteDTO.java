package com.example.morejonb.dto;

import lombok.Data;

@Data
public class EstudianteDTO {
	
    private String nombre;
    private String cedula;
    private double asistencia;
    private double deberes;
    private double trabajos;
    private double examen;
}