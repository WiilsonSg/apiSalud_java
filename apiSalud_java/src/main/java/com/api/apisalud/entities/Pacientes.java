package com.api.apisalud.entities;

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

    @Column(name = "age")
    private Integer edad;

    @Column(name = "phone")
    private String phonePaciente;

}


