package com.example.grupod_atencionpersonasmayoressise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.grupod_atencionpersonasmayoressise.Dto.PacienteDto;
import com.example.grupod_atencionpersonasmayoressise.Mapppers.PacienteMapper;
import com.example.grupod_atencionpersonasmayoressise.iservices.IPacienteService;
import com.example.grupod_atencionpersonasmayoressise.model.Paciente;
import com.example.grupod_atencionpersonasmayoressise.repository.PacienteRepository;

@Service
public class PacienteService implements IPacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente obtenerPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente eliminarLogico(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente != null) {
            paciente.setEstado(0);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public List<PacienteDto> listarPacienteDtos() {
        List<Paciente> listaPaciente = pacienteRepository.findAll();
        return PacienteMapper.pacienteDtos(listaPaciente);
    }

    @Override
    public Page<PacienteDto> paginado(String search, Pageable pageable) {
        Page<Paciente> pacientePage = pacienteRepository.paginado(search, pageable);
        Page<PacienteDto> dtoPage = pacientePage.map(PacienteMapper::pacienteDto);
        return dtoPage;
    }

}
