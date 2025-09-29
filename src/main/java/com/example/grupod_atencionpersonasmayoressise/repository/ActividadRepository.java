package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grupod_atencionpersonasmayoressise.model.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad,Long> {
    
}
