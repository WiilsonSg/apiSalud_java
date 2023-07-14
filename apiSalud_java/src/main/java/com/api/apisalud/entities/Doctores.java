package com.api.apisalud.entities;

import com.api.apisalud.converter.EspecialidadConverter;
import com.api.apisalud.utils.Especialidad;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Doctores{
    @Id
    @Column(name = "cc")
    private Long cc;
    @Column(name = "name")
    private String nameDoctor;
    @Column(name = "lastname")
    private String lastNameDoctor;

    @Column(name = "consultorio")
    private String consultorio;

    @Column(name = "email")
    private String email;


    @Column(columnDefinition = "VARCHAR(255)")
    @Enumerated(EnumType.STRING)
    @Convert(converter = EspecialidadConverter.class)
    private Especialidad especialidad;
}
