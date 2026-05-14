package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.model.Nota;
import com.example.demo.service.NotaService;

@RestController
@RequestMapping("/notas")
@CrossOrigin(origins = "*") // IMPORTANTE para el frontend
public class NotaController {

    @Autowired
    private NotaService service;

    // ✅ GET → listar
    @GetMapping
    public ResponseEntity<List<Nota>> listar() {
        List<Nota> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    // ✅ POST → guardar
    @PostMapping
    public ResponseEntity<Nota> guardar(@RequestBody Nota nota) {
        Nota nueva = service.guardar(nota);
        return ResponseEntity.ok(nueva);
    }

    // ✅ PUT → actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Nota nota) {
        Nota actualizada = service.actualizar(id, nota);

        if (actualizada == null) {
            return ResponseEntity.notFound().build(); // 404 si no existe
        }

        return ResponseEntity.ok(actualizada);
    }

    // ✅ DELETE → eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}