package com.disney.app.mapper;

import com.disney.app.dto.MultimediaDTO;
import com.disney.app.dto.PersonajeDTO;
import com.disney.app.model.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonajeMapper {
    @Autowired
    MultimediaMapper mapper;

    public PersonajeDTO map(Personaje personaje){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setImage(personaje.getImage());
        personajeDTO.setName(personaje.getName());
        return personajeDTO;
    }

    public Personaje mapToEntity(PersonajeDTO dto){
        Personaje personaje = new Personaje();
        personaje.setImage(dto.getImage());
        personaje.setName(dto.getName());
        personaje.setHistory(dto.getHistory());
        personaje.setAge(dto.getAge());
        personaje.setWeigh(dto.getWeigh());
        return personaje;
    }
    public  Personaje mapToEntityId(PersonajeDTO dto){
        Personaje personaje = this.mapToEntity(dto);
        personaje.setId(dto.getId());
        return  personaje;
    }

    public PersonajeDTO mapAll(Personaje personaje){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setName(personaje.getName());
        personajeDTO.setWeigh(personaje.getWeigh());
        personajeDTO.setAge(personaje.getAge());
        personajeDTO.setHistory(personaje.getHistory());
        personajeDTO.setImage(personaje.getImage());
        personajeDTO.setMultimedia(personaje.getMultimedia().stream().map(multimedia -> this.mapper.mapAll(multimedia)).collect(Collectors.toList()));
        return personajeDTO;
    }

    public PersonajeDTO mapWithOutMultimedia(Personaje personaje){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setName(personaje.getName());
        personajeDTO.setWeigh(personaje.getWeigh());
        personajeDTO.setAge(personaje.getAge());
        personajeDTO.setHistory(personaje.getHistory());
        personajeDTO.setImage(personaje.getImage());
        return personajeDTO;
    }
}
