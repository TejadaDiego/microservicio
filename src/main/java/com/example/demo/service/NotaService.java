package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Nota;
import com.example.demo.repository.NotaRepository;

@Service
public class NotaService {

    @Autowired
    private NotaRepository repository;

    // =========================
    // LISTAR
    // =========================
    public List<Nota> listar() {

        return repository.findAll();
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public Nota buscarPorId(Long id) {

        Optional<Nota> nota =
                repository.findById(id);

        return nota.orElse(null);
    }

    // =========================
    // GUARDAR
    // =========================
    public Nota guardar(Nota nota) {

        return repository.save(nota);
    }

    // =========================
    // ACTUALIZAR
    // =========================
    public Nota actualizar(Long id, Nota nota) {

        Nota existente =
                repository.findById(id)
                          .orElse(null);

        if (existente == null) {

            return null;
        }

        existente.setEstudianteId(
                nota.getEstudianteId());

        existente.setCurso(
                nota.getCurso());

        existente.setNota(
                nota.getNota());

        return repository.save(existente);
    }

    // =========================
    // ELIMINAR
    // =========================
    public void eliminar(Long id) {

        repository.deleteById(id);
    }
}