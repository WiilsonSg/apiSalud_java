package com.api.apisalud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apisalud.entities.Pacientes;
import com.api.apisalud.services.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    //CREAR PACIENTE
    @PostMapping("/created")
    public ResponseEntity<Void> createPaciente(@RequestBody Pacientes paciente){
        pacienteService.newPaciente(paciente);
        return ResponseEntity.status(201).build();
    }

    //BUSCAR TODOS LOS PACIENTES
    @GetMapping("/search")
    public ResponseEntity<List<Pacientes>> encontrarTodosPac(){
        List<Pacientes> paciente = pacienteService.findAllPacientes();
        return ResponseEntity.ok(paciente);
    }

    //BUSCAR TODOS LOS DOCTORES POR ID
    @GetMapping ("/pacientes/{cc}")
    public Pacientes mostrarPorIdPaciente (@PathVariable long cc){
        return pacienteService.findPacienteById(cc);
    }
}
