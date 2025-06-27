package com.example.morejonb.serviceimpl;

import com.example.morejonb.dto.EstudianteDTO;
import com.example.morejonb.model.Estudiantes;
import com.example.morejonb.repository.EstudianteRepository;
import com.example.morejonb.service.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstudianteServiceImpl implements EstudiantesService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Estudiantes calcularYGuardarNota(EstudianteDTO dto) {

        
        if (estudianteRepository.findByCedula(dto.getCedula()).isPresent()) {
            throw new IllegalStateException("La cédula " + dto.getCedula() + " ya está registrada.");
        }

       
        double notaFinal = (dto.getAsistencia() * 0.10) +
                           (dto.getDeberes() * 0.20) +
                           (dto.getTrabajos() * 0.30) +
                           (dto.getExamen() * 0.40);

        
        Estudiantes estudiante = new Estudiantes();
        estudiante.setNombre(dto.getNombre());
        estudiante.setCedula(dto.getCedula());
        estudiante.setCalifAsistencia(dto.getAsistencia());
        estudiante.setCalifDeberes(dto.getDeberes());
        estudiante.setCalifTrabajos(dto.getTrabajos());
        estudiante.setCalifExamen(dto.getExamen());
        estudiante.setNotaFinal(notaFinal);

        
        return estudianteRepository.save(estudiante);
    }
}