package com.disney.app.service;

import com.disney.app.dto.PersonajeDTO;
import com.disney.app.mapper.PersonajeMapper;
import com.disney.app.model.Personaje;
import com.disney.app.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    PersonajeRepository  repository;

    @Autowired
    PersonajeMapper mapper;

    @Override
    public List<PersonajeDTO> getPersonajes() {
        List<Personaje> listPersonajes = repository.findAll();
        return listPersonajes.stream().map(personaje-> mapper.map(personaje)).collect(Collectors.toList());
    }

    @Override
    public Long crear(PersonajeDTO personajeDto) {
        Personaje personaje = repository.save(mapper.mapToEntity(personajeDto));
        return personaje.getId();
    }

    public Long update(PersonajeDTO personajeDto){
        Optional<Personaje> personaje = repository.findById(personajeDto.getId());
        if ( personaje.isPresent() ){
            Personaje newPersonaje = mapper.mapToEntity(personajeDto);
            newPersonaje.setId(personajeDto.getId());
            repository.save(newPersonaje);
            return newPersonaje.getId();
        }
        return  null;
    }

    public Long  delete(Long id) {
        Optional<Personaje> personajeOptional = repository.findById(id);
        if (personajeOptional.isPresent()) {
            repository.deleteById(id);
            return personajeOptional.get().getId();
        }
        return null ;
    }

    public PersonajeDTO detalle(Long id){
        Optional<Personaje> personaje = repository.findById(id);
        return personaje.map(value -> mapper.mapAll(value)).orElse(null);
    }

    @Override
    public List<PersonajeDTO> filter(String name, Integer age , Long id) {
        List<Personaje> personajes = repository.findByNameAndAge(name,age,id);
        return personajes.stream().map(p -> mapper.map(p)).collect(Collectors.toList());
    }

}
