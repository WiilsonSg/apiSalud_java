package com.api.apisalud.persistence;

import com.api.apisalud.entities.Doctores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ImpleDoctorDao extends JpaRepository<Doctores, Long>{
    Optional<Doctores> findByNameDoctor(String name);
}
