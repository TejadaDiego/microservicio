package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.model.Nota;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.NotaRepository;
import com.example.demo.repository.EstudianteRepository;

@Service
public class NotaService {

    @Autowired
    private NotaRepository repository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    // ✅ LISTAR
    public List<Nota> listar() {
        return repository.findAll();
    }

    // ✅ GUARDAR
    public Nota guardar(Nota nota) {

        if (nota.getEstudiante() == null || nota.getEstudiante().getId() == null) {
            throw new RuntimeException("Debe enviar un ID de estudiante válido");
        }

        Long estudianteId = nota.getEstudiante().getId();

        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no existe con ID: " + estudianteId));

        nota.setEstudiante(estudiante);

        return repository.save(nota);
    }

    // ✅ ACTUALIZAR
    public Nota actualizar(Long id, Nota nota) {

        Nota existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con ID: " + id));

        if (nota.getEstudiante() == null || nota.getEstudiante().getId() == null) {
            throw new RuntimeException("Debe enviar un ID de estudiante válido");
        }

        Long estudianteId = nota.getEstudiante().getId();

        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no existe con ID: " + estudianteId));

        existente.setEstudiante(estudiante);
        existente.setCurso(nota.getCurso());
        existente.setNota(nota.getNota());

        return repository.save(existente);
    }

    // ✅ ELIMINAR
    public void eliminar(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Nota no encontrada con ID: " + id);
        }

        repository.deleteById(id);
    }
}