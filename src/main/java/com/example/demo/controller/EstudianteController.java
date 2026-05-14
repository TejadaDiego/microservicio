package com.example.demo.controller;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "*") // opcional (para frontend)
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // ✅ LISTAR TODOS
    @GetMapping
    public List<Estudiante> listar() {
        return estudianteRepository.findAll();
    }

    // ✅ GUARDAR
    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // ✅ BUSCAR POR ID
    @GetMapping("/{id}")
    public Estudiante buscarPorId(@PathVariable Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    // ✅ ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
    }
}