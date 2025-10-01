package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.grupod_atencionpersonasmayoressise.model.Empleado;
import com.example.grupod_atencionpersonasmayoressise.model.Rol;

public interface IRolService {
    List<Rol> listar();

    Rol guardar(Rol rol);

    Rol obtenerPorId(Long id);

    Rol actualizar(Rol rol);

    Rol elimarLogico(Long id);
    public Page<Rol> paginado(String search, Pageable pageable);
}
