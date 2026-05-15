package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 ID DEL ESTUDIANTE
    @Column(name = "estudiante_id", nullable = false)
    private Long estudianteId;

    @Column(name = "curso", nullable = false)
    private String curso;

    @Column(name = "nota", nullable = false)
    private double nota;

    // =========================
    // CONSTRUCTOR VACÍO
    // =========================
    public Nota() {
    }

    // =========================
    // CONSTRUCTOR
    // =========================
    public Nota(
            Long estudianteId,
            String curso,
            double nota) {

        this.estudianteId = estudianteId;
        this.curso = curso;
        this.nota = nota;
    }

    // =========================
    // GETTERS Y SETTERS
    // =========================

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getEstudianteId() {

        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {

        this.estudianteId = estudianteId;
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
}