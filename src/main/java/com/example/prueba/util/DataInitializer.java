package com.example.prueba.util;

import com.example.prueba.entity.*;
import com.example.prueba.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ColegioRepository colegioRepository;
    private final CursoRepository cursoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final ProfesorRepository profesorRepository;
    private final EstudianteRepository estudianteRepository;

    public DataInitializer(ColegioRepository colegioRepository,
                           CursoRepository cursoRepository,
                           AsignaturaRepository asignaturaRepository,
                           ProfesorRepository profesorRepository,
                           EstudianteRepository estudianteRepository) {
        this.colegioRepository = colegioRepository;
        this.cursoRepository = cursoRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.profesorRepository = profesorRepository;
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public void run(String... args) {
        // Crear Colegio
        Colegio colegio = new Colegio("El colegio del Olimpo");
        colegioRepository.save(colegio);

        // Crear Cursos
        Curso curso10A = new Curso("10", "A", colegio);
        Curso curso10B = new Curso("10", "B", colegio);
        Curso curso11A = new Curso("11", "A", colegio);
        Curso curso11B = new Curso("11", "B", colegio);
        cursoRepository.saveAll(Arrays.asList(curso10A, curso10B, curso11A, curso11B));

        // Crear Profesores
        Profesor nemesis = new Profesor("Némesis");
        Profesor priapo = new Profesor("Príapo");
        Profesor iris = new Profesor("Iris");
        profesorRepository.saveAll(Arrays.asList(nemesis, priapo, iris));

        // Crear Estudiantes
        List<Estudiante> estudiantes = Arrays.asList(
                new Estudiante("Afrodita"),
                new Estudiante("Apolo"),
                new Estudiante("Ares"),
                new Estudiante("Artemisa"),
                new Estudiante("Atenea"),
                new Estudiante("Dionisio"),
                new Estudiante("Hefesto"),
                new Estudiante("Hera"),
                new Estudiante("Hermes"),
                new Estudiante("Hades"),
                new Estudiante("Poseidón"),
                new Estudiante("Zeus")
        );
        estudianteRepository.saveAll(estudiantes);

        // Dividir Estudiantes entre los Cursos según la tabla
        List<Estudiante> estudiantes10A = estudiantes.subList(0, 3);
        List<Estudiante> estudiantes10B = estudiantes.subList(3, 6);
        List<Estudiante> estudiantes11A = estudiantes.subList(6, 8);
        List<Estudiante> estudiantes11B = estudiantes.subList(8, 12);

        // Crear Asignaturas
        Asignatura matematicas10A = new Asignatura("Matemáticas", curso10A, nemesis);
        matematicas10A.getEstudiantes().addAll(estudiantes10A);

        Asignatura matematicas10B = new Asignatura("Matemáticas", curso10B, nemesis);
        matematicas10B.getEstudiantes().addAll(estudiantes10B);

        Asignatura matematicas11A = new Asignatura("Matemáticas", curso11A, nemesis);
        matematicas11A.getEstudiantes().addAll(estudiantes11A);

        Asignatura matematicas11B = new Asignatura("Matemáticas", curso11B, nemesis);
        matematicas11B.getEstudiantes().addAll(estudiantes11B);

        Asignatura preIcfes11A = new Asignatura("Pre Icfes", curso11A, nemesis);
        preIcfes11A.getEstudiantes().addAll(estudiantes11A);

        Asignatura preIcfes11B = new Asignatura("Pre Icfes", curso11B, nemesis);
        preIcfes11B.getEstudiantes().addAll(estudiantes11B);

        Asignatura espanol10A = new Asignatura("Español", curso10A, priapo);
        espanol10A.getEstudiantes().addAll(estudiantes10A);

        Asignatura espanol10B = new Asignatura("Español", curso10B, priapo);
        espanol10B.getEstudiantes().addAll(estudiantes10B);

        Asignatura inglesBasico10A = new Asignatura("Ingles básico", curso10A, iris);
        inglesBasico10A.getEstudiantes().addAll(estudiantes10A);

        Asignatura inglesAvanzado10B = new Asignatura("Ingles avanzado", curso10B, iris);
        inglesAvanzado10B.getEstudiantes().addAll(estudiantes10B);

        asignaturaRepository.saveAll(Arrays.asList(
                matematicas10A, matematicas10B, matematicas11A, matematicas11B,
                preIcfes11A, preIcfes11B, espanol10A, espanol10B, inglesBasico10A, inglesAvanzado10B
        ));
    }


}
