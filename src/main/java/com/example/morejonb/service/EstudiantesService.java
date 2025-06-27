package com.example.morejonb.service;

import com.example.morejonb.dto.EstudianteDTO;
import com.example.morejonb.model.Estudiantes;

public interface EstudiantesService {
	
	Estudiantes calcularYGuardarNota(EstudianteDTO dto);

}

