package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.grupod_atencionpersonasmayoressise.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    Page<Cita> findAll(Pageable pageable);

    @Query("SELECT c FROM Cita c WHERE (:search IS NULL OR c.id_cita = :search)")
    Page<Cita> paginado(@Param("search") Long search, Pageable pageable);
}
