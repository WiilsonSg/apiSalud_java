package com.api.apisalud.converter;

import com.api.apisalud.utils.Especialidad;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EspecialidadConverter implements AttributeConverter<Especialidad, String> {

@Override
public String convertToDatabaseColumn(Especialidad especialidad) {
        return especialidad.name();
        }

@Override
public Especialidad convertToEntityAttribute(String nombre) {
        return Especialidad.valueOf(nombre);
        }

}
