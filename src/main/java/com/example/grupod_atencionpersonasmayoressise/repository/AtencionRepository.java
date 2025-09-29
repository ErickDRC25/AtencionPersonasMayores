package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grupod_atencionpersonasmayoressise.model.Atencion;

public interface AtencionRepository extends JpaRepository<Atencion,Long> {
    
}
