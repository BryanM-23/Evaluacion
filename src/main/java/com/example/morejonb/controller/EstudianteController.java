package com.example.morejonb.controller;

import com.example.morejonb.dto.EstudianteDTO;
import com.example.morejonb.model.Estudiantes;
import com.example.morejonb.service.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class EstudianteController {

    @Autowired
    private EstudiantesService estudiantesService;

    
    @GetMapping("/")
    public String mostrarFormulario(Model model) {
       
        model.addAttribute("estudianteDTO", new EstudianteDTO());
        return "formulario"; 
    }

   
    @PostMapping("/calcular")
    public String procesarCalculo(@ModelAttribute EstudianteDTO estudianteDTO, Model model) {
        try {
           
            Estudiantes resultado = estudiantesService.calcularYGuardarNota(estudianteDTO);
            
            model.addAttribute("resultadoExitoso", resultado);
        } catch (IllegalStateException e) {
            
            model.addAttribute("error", e.getMessage());
        }
        
        
        return "formulario";
    }
}