package com.api.apisalud.persistence;

import com.api.apisalud.entities.Citas;
import com.api.apisalud.utils.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImpleCitaDao extends JpaRepository <Citas, Long>{
    List<Citas> findByEspecialidad(Especialidad especialidad);
}
