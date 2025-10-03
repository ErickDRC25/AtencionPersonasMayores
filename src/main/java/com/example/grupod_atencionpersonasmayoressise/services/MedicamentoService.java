package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.iservices.IMedicamentoService;
import com.example.grupod_atencionpersonasmayoressise.model.Medicamento;
import com.example.grupod_atencionpersonasmayoressise.repository.MedicamentoRepository;

@Service
public class MedicamentoService implements IMedicamentoService {
    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> listar() {
        return medicamentoRepository.findAll();
    }

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @Override
    public Medicamento obtenerPorId(Long id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    @Override
    public Medicamento actualizar(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);

    }

    @Override
    public Medicamento eliminarLogico(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id).orElse(null);
        if (medicamento != null) {
            medicamento.setEstado(0);
            return medicamentoRepository.save(medicamento);
        }

        return null;
    }
}
