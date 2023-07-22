package com.api.apisalud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apisalud.dto.DtoDoctor;
import com.api.apisalud.dto.DtoDoctorAll;
import com.api.apisalud.entities.Doctores;
import com.api.apisalud.persistence.ImpleDoctorDao;

@Service
public class DoctoresService {

    @Autowired
    ImpleDoctorDao impleDoctorDao;

    @Autowired
    ModelMapper modelMapper;

    //CREAR DOCTOR
    public void newDoctor (DtoDoctorAll dtoDoctorAll){
        Doctores doctor= modelMapper.map(dtoDoctorAll, Doctores.class);
        Optional<Doctores> existeDoctor = impleDoctorDao.findById(dtoDoctorAll.getCc());
        if(existeDoctor.isPresent()){
            throw new RuntimeException("no se puede guardar, doctor ya con este nombre ya se encuentra registrado");
        }
        impleDoctorDao.save(doctor);
    }

    //BUSCAR TODOS LOS DOCTORES
    public List<DtoDoctorAll> findAll(){
        List<Doctores> doctores = impleDoctorDao.findAll();
        List<DtoDoctorAll> doctorAllList = doctores.stream()
                .map(doctor -> modelMapper.map(doctor, DtoDoctorAll.class))
                .collect(Collectors.toList());
        return doctorAllList;
    }

    //BUSCAR TODOS DOCTORES POR ID
    public DtoDoctor findById(Long cc){
        Optional<Doctores> doctores = impleDoctorDao.findById(cc);
        if (doctores.isEmpty()){
            throw new RuntimeException("no existe doctor con esa cédula");
        }
        DtoDoctor dtoDoctor = modelMapper.map(doctores.get(), DtoDoctor.class);
        return dtoDoctor;
    }

    //ACTUALIZAR DATOS DOCTOR
    public void save (DtoDoctorAll dtoDoctorAll){
        Doctores doctores = modelMapper.map(dtoDoctorAll, Doctores.class);
        Optional<Doctores> doctorExiste = impleDoctorDao.findById(dtoDoctorAll.getCc());
        if(doctorExiste.isEmpty()){
            throw new RuntimeException("usuario ya existe, intente de nuevo");
        }
        impleDoctorDao.save(doctores);
    }


    // ELIMINAR UN DOCTOR
    public void delete(Long cc){
        Optional<Doctores> eliminarDoctor = impleDoctorDao.findById(cc);
        if(eliminarDoctor.isEmpty()){
            throw new RuntimeException("no se encuentra registro para eliminar");
        }
        impleDoctorDao.delete(eliminarDoctor.get());
    }
}
