package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Nota;
import com.example.demo.service.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService service;

    // =========================
    // LISTAR
    // =========================
    @GetMapping
    public List<Nota> listar() {

        return service.listar();
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    @GetMapping("/{id}")
    public Nota buscar(@PathVariable Long id) {

        return service.buscarPorId(id);
    }

    // =========================
    // GUARDAR
    // =========================
    @PostMapping
    public Nota guardar(@RequestBody Nota nota) {

        return service.guardar(nota);
    }

    // =========================
    // ACTUALIZAR
    // =========================
    @PutMapping("/{id}")
    public Nota actualizar(
            @PathVariable Long id,
            @RequestBody Nota nota) {

        return service.actualizar(id, nota);
    }

    // =========================
    // ELIMINAR
    // =========================
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        service.eliminar(id);
    }
}