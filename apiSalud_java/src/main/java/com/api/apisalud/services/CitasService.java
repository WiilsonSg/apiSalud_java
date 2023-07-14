package com.api.apisalud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apisalud.dto.DtoCitaEspecialidad;
import com.api.apisalud.entities.Citas;
import com.api.apisalud.entities.Doctores;
import com.api.apisalud.entities.Pacientes;
import com.api.apisalud.persistence.ImpleCitaDao;
import com.api.apisalud.persistence.ImpleDoctorDao;
import com.api.apisalud.persistence.ImplePacienteDao;
import com.api.apisalud.utils.Especialidad;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CitasService {

    @Autowired
    ImpleDoctorDao impleDoctorDao;

    @Autowired
    ImplePacienteDao implePacienteDao;

    @Autowired
    ImpleCitaDao impleCitaDao;

    @Autowired
    ModelMapper modelMapper;

    //CREAR CITAS POR EL NOMBRE DEL DOCTOR
    public void crearCita(Citas citas) {
        Optional<Doctores> optionalDoctor = impleDoctorDao.findById(citas.getDoctores().getCc());
        Doctores doctor = optionalDoctor.orElseThrow(() -> new EntityNotFoundException("Doctor no encontrado"));

        // Obtener el paciente existente de la base de datos
        Optional<Pacientes> optionalPaciente = implePacienteDao.findById(citas.getPacientes().getCc());
        Pacientes paciente = optionalPaciente.orElseThrow(() -> new EntityNotFoundException("Paciente no encontrado"));

        // Asignar el paciente existente a la cita
        citas.setPacientes(paciente);
        citas.setDoctores(doctor);

        impleCitaDao.save(citas);
    }



    //CONSULTAR CITAS POR ESPECIALIDAD
    public List<DtoCitaEspecialidad> getCitasByEspecialidad(String nombreEspecialidad) {
        Especialidad especialidad = Especialidad.valueOf(nombreEspecialidad.toUpperCase());
        List<Citas> citas = impleCitaDao.findByEspecialidad(especialidad);
        List<DtoCitaEspecialidad> dtoCitaEspecialidad = new ArrayList<>();

        for (Citas cita : citas) {
            DtoCitaEspecialidad dtoCita = new DtoCitaEspecialidad();
            dtoCita.setEspecialidad(cita.getEspecialidad());
            dtoCita.setNamePaciente(cita.getPacientes().getNamePaciente());
            dtoCita.setLastNamePaciente(cita.getPacientes().getLastNamePaciente());
            dtoCita.setNameDoctor(cita.getDoctores().getNameDoctor());
            dtoCita.setLastNameDoctor(cita.getDoctores().getLastNameDoctor());
            dtoCita.setConsultorio(cita.getDoctores().getConsultorio());

            dtoCitaEspecialidad.add(dtoCita);
        }

        return dtoCitaEspecialidad;
    }
}
