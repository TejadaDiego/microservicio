package com.example.demo.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 RELACIÓN MUCHOS A UNO
    @ManyToOne(fetch = FetchType.EAGER) // 🔥 CAMBIO IMPORTANTE
    @JoinColumn(name = "estudiante_id", nullable = false)
    @JsonIgnoreProperties({"notas"}) // evita bucle infinito
    private Estudiante estudiante;

    @Column(name = "curso", nullable = false, length = 100)
    private String curso;

    @Column(name = "nota", nullable = false)
    private double nota;

    // ✅ CONSTRUCTOR VACÍO
    public Nota() {
    }

    // ✅ CONSTRUCTOR
    public Nota(Estudiante estudiante, String curso, double nota) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.nota = nota;
    }

    // ========================
    // GETTERS Y SETTERS
    // ========================

    public Long getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setId(Long id) {
        this.id = id;
    }
}