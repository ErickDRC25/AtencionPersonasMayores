package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.IEmpleadoService;
import com.example.grupod_atencionpersonasmayoressise.model.Empleado;
import com.example.grupod_atencionpersonasmayoressise.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado actualizar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado eliminarLogico(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            empleado.setEstado(0);
            return empleadoRepository.save(empleado);
        }

        return null;
    }

    @Override
    public Page<Empleado> paginado(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return empleadoRepository.findAll(pageable);
        }
        return empleadoRepository.paginado(search, pageable);

    }
}
