package com.api.apisalud.dto;

import com.api.apisalud.utils.Especialidad;
import lombok.Data;

import java.io.Serializable;

@Data
public class DtoCitaEspecialidad implements Serializable {
    private Especialidad especialidad;
    private String namePaciente;
    private String lastNamePaciente;
    private String nameDoctor;
    private String lastNameDoctor;
    private String consultorio;

}
