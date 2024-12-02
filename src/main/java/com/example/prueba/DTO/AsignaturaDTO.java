package com.example.prueba.DTO;


import java.util.List;

public class AsignaturaDTO {
    private String nombre;
    private String curso;
    private List<String> estudiantes;


    public AsignaturaDTO(String nombre, String curso, List<String> estudiantes) {
        this.nombre = nombre;
        this.curso = curso;
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public List<String> getEstudiantes() {
        return estudiantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setEstudiantes(List<String> estudiantes) {
        this.estudiantes = estudiantes;
    }
}