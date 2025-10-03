package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.IFamiliarService;
import com.example.grupod_atencionpersonasmayoressise.model.Familiar;
import com.example.grupod_atencionpersonasmayoressise.repository.FamiliarRepository;

@Service
public class FamiliarService implements IFamiliarService {
    @Autowired
    FamiliarRepository familiarRepository;

    @Override
    public List<Familiar> listar() {
        return familiarRepository.findAll();
    }

    @Override
    public Familiar guardar(Familiar familiar) {
        return familiarRepository.save(familiar);
    }

    @Override
    public Familiar obtenerPorId(Long id) {
        return familiarRepository.findById(id).orElse(null);
    }

    @Override
    public Familiar actualizar(Familiar familiar) {
        return familiarRepository.save(familiar);
    }

    @Override
    public Familiar eliminarLogico(Long id) {
        Familiar familiar = familiarRepository.findById(id).orElse(null);

        if (familiar != null) {
            familiar.setEstado(0);
            return familiarRepository.save(familiar);
        }

        return null;
    }
}
