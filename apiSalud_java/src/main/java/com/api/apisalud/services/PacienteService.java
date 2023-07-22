package com.api.apisalud.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apisalud.entities.Pacientes;
import com.api.apisalud.persistence.ImplePacienteDao;

@Service
public class PacienteService {

    @Autowired
    ImplePacienteDao implePacienteDao;

    @Autowired
    ModelMapper modelMapper;


//CREAR PACIENTE
    public void newPaciente(Pacientes paciente) {
        Optional<Pacientes> existePaciente = implePacienteDao.findById(paciente.getCc());
        if (existePaciente.isPresent()) {
            throw new RuntimeException("No se puede guardar, paciente con este nombre ya se encuentra registrado");
        }

        // Calcula la edad a partir de la fecha de nacimiento y la fecha actual
        LocalDate birthdateLocal = paciente.getCumple().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthdateLocal, currentDate);
        int edad = period.getYears();

        // Establece la edad del paciente antes de guardarlo
        paciente.setEdad(edad);

        implePacienteDao.save(paciente);
    }

    //LISTAR TODOS LOS PACIENTES
    public List<Pacientes> findAllPacientes(){
        List<Pacientes> pacientes = implePacienteDao.findAll();
        return pacientes;
    }

    public Pacientes findPacienteById(Long cc) {
        Optional<Pacientes> encontrarPaciente = implePacienteDao.findById(cc);
        if (encontrarPaciente.isEmpty()) {
            throw new RuntimeException("No se encontró un paciente con la cédula proporcionada, intente nuevamente");
        }
        return encontrarPaciente.get();
    }


}
