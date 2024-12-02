package com.example.prueba.repository;

import com.example.prueba.entity.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColegioRepository extends JpaRepository<Colegio, Long> {}
