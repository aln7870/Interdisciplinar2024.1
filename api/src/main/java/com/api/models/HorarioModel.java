package com.api.models;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "horario")
public class HorarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_horario")
    private Long idHorario;

    @Column(name = "Dia_da_semana", nullable = false)
    private String diaDaSemana;

    @Column(name = "Hora_inicio", nullable = false)
    private Time horaInicio;

    @Column(name = "Hora_terminio", nullable = false)
    private Time horaTerminio;

    @Column(name = "id_turma", nullable = false)
    private Long idTurma;

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraTerminio() {
        return horaTerminio;
    }

    public void setHoraTerminio(Time horaTerminio) {
        this.horaTerminio = horaTerminio;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }
}
