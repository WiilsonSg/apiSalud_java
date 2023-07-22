package com.api.apisalud.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apisalud.dto.DtoDoctor;
import com.api.apisalud.dto.DtoDoctorAll;
import com.api.apisalud.services.DoctoresService;

@RestController
@RequestMapping("/home")
public class DoctorController {

    @Autowired
    DoctoresService docService;

    @Autowired
    private ModelMapper modelMapper;

    //CREAR DOCTOR
    @PostMapping ("/created")
    public ResponseEntity<Void> createDoctor(@RequestBody DtoDoctorAll dtoDoctorAll){
        docService.newDoctor(dtoDoctorAll);
        return ResponseEntity.status(201).build();
    }

    //BUSCAR TODOS LOS DOCTORES
    @GetMapping ("/doctores")
    public ResponseEntity<List<DtoDoctorAll>> encontrarTodosDoc(){
        List<DtoDoctorAll> dtoDoctorAll = docService.findAll();
        return ResponseEntity.ok(dtoDoctorAll);
    }

    //BUSCAR TODOS LOS DOCTORES POR ID
    @GetMapping ("/doctores/{cc}")
    public DtoDoctor mostrarPorId (@PathVariable long cc){
        return docService.findById(cc);
    }

    //ACTUALIZAR DOCTOR
    @PutMapping("/doctores/{cc}")
    public ResponseEntity<Void> updateDoctor(@PathVariable long cc, @RequestBody DtoDoctorAll dtoDoctorAll){
        docService.save(dtoDoctorAll);
        return ResponseEntity.ok().build();
    }

    //ELIMINAR DOCTOR
    @DeleteMapping("/delete/{cc}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable long cc){
        docService.delete(cc);
        return ResponseEntity.ok().build();
    }

}
