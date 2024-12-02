package com.example.prueba.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grado;
    private String salon;

    @ManyToOne
    private Colegio colegio;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Asignatura> asignaturas = new ArrayList<>();

    public Curso() {}

    public Curso(String grado, String salon, Colegio colegio) {
        this.grado = grado;
        this.salon = salon;
        this.colegio = colegio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
