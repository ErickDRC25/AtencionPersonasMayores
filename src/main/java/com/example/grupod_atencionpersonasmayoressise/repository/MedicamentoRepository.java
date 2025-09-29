package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grupod_atencionpersonasmayoressise.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento,Long> {
    
}
