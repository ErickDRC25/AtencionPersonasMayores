package com.example.grupod_atencionpersonasmayoressise.iservices;

import java.util.List;

import com.example.grupod_atencionpersonasmayoressise.model.Empleado;

public interface IEmpleadoService {
    List<Empleado> listar();

    Empleado guardar(Empleado empleado);

    Empleado obtenerPorId(Long id);

    Empleado actualizar(Empleado empleado);

    Empleado eliminarLogico(Long id); // estado  0
}
