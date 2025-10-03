package com.example.grupod_atencionpersonasmayoressise.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.grupod_atencionpersonasmayoressise.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    public Page<Rol> findAll(Pageable pageable);

    @Query(value = "SELECT r From Rol r where LOWER(r.nombre) like LOWER(CONCAT('%',:search,'%'))")
    public Page<Rol> paginado(@Param(value = "search") String search, Pageable pageable);
}
