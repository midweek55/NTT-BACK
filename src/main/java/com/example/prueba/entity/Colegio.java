package com.example.prueba.entity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Colegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "colegio", cascade = CascadeType.ALL)
    private List<Curso> cursos = new ArrayList<>();

    public Colegio() {}

    public Colegio(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}






