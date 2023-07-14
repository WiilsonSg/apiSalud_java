package com.api.apisalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.apisalud.dto.DtoCitaEspecialidad;
import com.api.apisalud.entities.Citas;
import com.api.apisalud.services.CitasService;
import com.api.apisalud.utils.Especialidad;
@RestController
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    CitasService citasService;



    //MÉTODO CREAR CITAS POR NOMBRE DEL DOCTOR
    @PostMapping("/created")
    public ResponseEntity<Void> crearCita(@RequestBody Citas citas) {
        citasService.crearCita(citas);
        return ResponseEntity.ok().build();
    }


    //MÉTODO CONSULTAR CITAS POR ESPECIALIDAD
    @GetMapping("/especialidad")
    public List<DtoCitaEspecialidad> obtenerCitaPorEspecialidad(@RequestParam String especialidad) {
        try {
            Especialidad.valueOf(especialidad.toUpperCase());
            return citasService.getCitasByEspecialidad(especialidad);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Especialidad no válida");
        }
    }

}
