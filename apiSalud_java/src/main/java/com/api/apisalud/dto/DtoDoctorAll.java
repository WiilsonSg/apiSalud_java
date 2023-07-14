package com.api.apisalud.dto;

import java.io.Serializable;

import com.api.apisalud.utils.Especialidad;

import lombok.Data;

@Data
public class DtoDoctorAll implements Serializable{

    private long cc;

    private String name;

    private String lastName;


    private String consultorio;


    private String email;


    private Especialidad especialidad;
}
