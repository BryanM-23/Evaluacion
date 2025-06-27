package com.example.morejonb.repository;

import org.springframework.stereotype.Repository;

import com.example.morejonb.model.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository

public interface EstudianteRepository extends JpaRepository<Estudiantes, Long> {
    
        Optional<Estudiantes> findByCedula(String cedula);
}
