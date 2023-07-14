package com.api.apisalud.entities;

import com.api.apisalud.utils.Especialidad;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "fk_pacientes")
    @ManyToOne
    private Pacientes pacientes;

    @JoinColumn(name = "fk_doctores")
    @ManyToOne
    private Doctores doctores;

    private Especialidad especialidad;
}
