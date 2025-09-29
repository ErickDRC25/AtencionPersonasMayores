package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.IRolService;
import com.example.grupod_atencionpersonasmayoressise.model.Rol;
import com.example.grupod_atencionpersonasmayoressise.repository.RolRepository;
@Service
public class RolService implements IRolService {

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol obtenerPorId(Long id) {
       return rolRepository.findById(id).orElse(null);
    }

    @Override
    public Rol actualizar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol elimarLogico(Long id) {
        Rol rol = rolRepository.findById(id).orElse(null);
        if (rol != null) {
            rol.setEstado(0); 
            return rolRepository.save(rol);
        }
        return null;
    }
    
     
}
