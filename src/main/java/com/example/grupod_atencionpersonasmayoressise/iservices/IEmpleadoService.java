package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.grupod_atencionpersonasmayoressise.model.Empleado;

public interface IEmpleadoService {
    List<Empleado> listar();

    Empleado guardar(Empleado empleado);

    Empleado obtenerPorId(Long id);

    Empleado actualizar(Empleado empleado);

    Empleado eliminarLogico(Long id);

    public Page<Empleado> paginado(String search, Pageable pageable);
}
