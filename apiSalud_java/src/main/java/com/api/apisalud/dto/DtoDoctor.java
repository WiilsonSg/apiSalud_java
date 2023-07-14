package com.api.apisalud.dto;

import com.api.apisalud.utils.Especialidad;
import lombok.Data;

import java.io.Serializable;

@Data
public class DtoDoctor implements Serializable {
    private long cc;
    private String name;

    private String lastName;

    private String consultorio;


    private Especialidad especialidad;
}
