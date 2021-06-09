package com.disney.app.controller;

import com.disney.app.dto.PersonajeDTO;
import com.disney.app.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/characters")
public class PersonajeController {

    @Autowired
    PersonajeService service;

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> find(@RequestParam(required = false) String name,@RequestParam(required = false) Integer age,@RequestParam(required = false) Long id){
        if(canFilter(name,age,id)){
            return new ResponseEntity<>(service.filter(name,age,id),HttpStatus.OK);
        }
        return new ResponseEntity<>(service.getPersonajes(), HttpStatus.OK);
    }

    private boolean canFilter(String name, Integer age, Long id) {
        return name != null || age != null || id != null;
    }

    @PutMapping
    public ResponseEntity<Long> create(@RequestBody PersonajeDTO personaje){
        return new ResponseEntity<>(service.crear(personaje), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> update(@RequestBody PersonajeDTO dto){
        Long idPersonaje = service.update(dto);
        if(idPersonaje != null){
            return new ResponseEntity<>(idPersonaje, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        Long idPersonaje = service.delete(id);
        if (idPersonaje != null){
            return new ResponseEntity<>(idPersonaje,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<PersonajeDTO> detalle(@PathVariable Long id){
        return new ResponseEntity<>(service.detalle(id) , HttpStatus.OK );
    }

}
