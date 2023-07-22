package com.api.apisalud.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Pacientes {
    @Id
    @Column(name = "cc")
    private long cc;

    @Column(name = "name")
    private String namePaciente;

    @Column(name = "lastname")
    private String lastNamePaciente;

    @Column(name = "date")
    private Date cumple;

    @Column(name = "phone")
    private String phonePaciente;

    @Column(name = "age")
    private Integer edad;

    // CALCULO DE EDAD
    public Integer getEdad() {
        if (cumple != null) {
            LocalDate birthdateLocal = cumple.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(birthdateLocal, currentDate);
            return period.getYears();
        }
        return null;
    }
}



