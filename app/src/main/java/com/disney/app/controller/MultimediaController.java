package com.disney.app.controller;

import com.disney.app.dto.MultimediaDTO;
import com.disney.app.service.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MultimediaController {

    @Autowired
    MultimediaService service;

    @GetMapping
    public ResponseEntity<List<MultimediaDTO>> getMovies(@RequestParam(required = false) String title, @RequestParam(required = false) Long id, @RequestParam(defaultValue="ASC") Sort.Direction order){
            return new ResponseEntity<>(service.filter(title,id,order),HttpStatus.OK);
    }

    /*detalle peliculas/series con sus personajes*/
    @GetMapping("/{id}")
    public  ResponseEntity<MultimediaDTO> getAll(@PathVariable Long id){
        return new ResponseEntity<>(service.getDetail(id),HttpStatus.OK);
    }

    /*crear modificar eliminar*/
    @PutMapping
    public ResponseEntity<Long> create(@RequestBody MultimediaDTO dto){
        return new ResponseEntity<>(service.crear(dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> update(@RequestBody MultimediaDTO dto){
        Long idMultimedia = service.update(dto);
        if(idMultimedia != null){
            return new ResponseEntity<>(idMultimedia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        Long idMultimedia = service.delete(id);
        if (idMultimedia != null){
            return new ResponseEntity<>(idMultimedia,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
