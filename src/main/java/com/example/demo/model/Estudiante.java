package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    // 🔥 RELACIÓN: un estudiante tiene muchas notas
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("estudiante") // evita bucle infinito sin ocultar todo
    private List<Nota> notas;

    // ✅ CONSTRUCTOR VACÍO (obligatorio para JPA)
    public Estudiante() {
    }

    // ✅ CONSTRUCTOR
    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    // ✅ GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}