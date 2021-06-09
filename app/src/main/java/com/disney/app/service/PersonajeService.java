package com.disney.app.service;

import com.disney.app.dto.PersonajeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonajeService {

    List<PersonajeDTO> getPersonajes();

    Long crear(PersonajeDTO personajeDTO);

    Long update(PersonajeDTO personajeDTO);

    Long delete(Long id);

    PersonajeDTO detalle(Long id);

    List<PersonajeDTO> filter(String name, Integer age, Long id);
}
