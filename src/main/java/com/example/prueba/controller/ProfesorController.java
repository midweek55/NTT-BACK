package com.example.prueba.controller;

import com.example.prueba.DTO.AsignaturaDTO;
import com.example.prueba.DTO.ResponseDto;
import com.example.prueba.entity.Profesor;
import com.example.prueba.service.ProfesorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/{id}/asignaturas")
    public ResponseEntity<ResponseDto<List<AsignaturaDTO>>> obtenerAsignaturasYEstudiantes(@PathVariable Long id) {
        List<AsignaturaDTO> asignaturas = profesorService.obtenerAsignaturasYEstudiantes(id);
        ResponseDto<List<AsignaturaDTO>> response = new ResponseDto<>(
                "Asignaturas obtenidas exitosamente",
                200,
                asignaturas
        );
        return ResponseEntity.ok(response);
    }
}

