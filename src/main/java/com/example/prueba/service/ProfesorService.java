package com.example.prueba.service;

import com.example.prueba.DTO.AsignaturaDTO;
import com.example.prueba.entity.Estudiante;
import com.example.prueba.entity.Profesor;
import com.example.prueba.repository.ProfesorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<AsignaturaDTO> obtenerAsignaturasYEstudiantes(Long profesorId) {
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        return profesor.getAsignaturas().stream()
                .map(asignatura -> {
                    // Log para depurar los estudiantes asociados a cada asignatura
                    System.out.println("Asignatura: " + asignatura.getNombre() + " - Estudiantes: " +
                            asignatura.getEstudiantes().stream()
                                    .map(Estudiante::getNombre)
                                    .collect(Collectors.joining(", ")));

                    return new AsignaturaDTO(
                            asignatura.getNombre(),
                            asignatura.getCurso().getGrado() + asignatura.getCurso().getSalon(),
                            asignatura.getEstudiantes().stream()
                                    .map(Estudiante::getNombre)
                                    .collect(Collectors.toList())
                    );
                })
                .collect(Collectors.toList());
    }
}
