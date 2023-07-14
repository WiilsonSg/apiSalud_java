package com.api.apisalud.persistence;

import com.api.apisalud.entities.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImplePacienteDao extends JpaRepository <Pacientes, Long>{
}
