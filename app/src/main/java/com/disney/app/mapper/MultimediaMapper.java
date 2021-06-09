package com.disney.app.mapper;

import com.disney.app.dto.MultimediaDTO;
import com.disney.app.model.Multimedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class MultimediaMapper{
    @Autowired
    PersonajeMapper mapper;
    @Autowired
    GeneroMapper map;

    public MultimediaDTO mapAll(Multimedia multimedia){
        MultimediaDTO multimediaDTO = new MultimediaDTO();
        multimediaDTO.setTitle(multimedia.getTitle());
        multimediaDTO.setId(multimedia.getId());
        multimediaDTO.setCreateAt(multimedia.getCreateAt());
        multimediaDTO.setScore(multimedia.getScore());
        multimediaDTO.setImage(multimedia.getImage());
        return multimediaDTO;
    }
    public MultimediaDTO  mapAllWithPersonaje(Multimedia multimedia) {
        MultimediaDTO multimediaDTO = this.mapAll(multimedia);
        if(multimedia.getPersonaje() != null)
            multimediaDTO.setPersonaje(multimedia.getPersonaje().stream().map(personaje -> this.mapper.mapWithOutMultimedia(personaje)).collect(Collectors.toList()));
        return multimediaDTO;
    }
    public MultimediaDTO mapMovies(Multimedia multimedia) {
        MultimediaDTO multimediaDTO = new MultimediaDTO();
        multimediaDTO.setTitle(multimedia.getTitle());
        multimediaDTO.setImage(multimedia.getImage());
        multimediaDTO.setCreateAt(multimedia.getCreateAt());
        return multimediaDTO;
    }
    public Multimedia mapToEntity(MultimediaDTO multimediaDTO){
        Multimedia multimedia = new Multimedia();
        multimedia.setTitle(multimediaDTO.getTitle());
        multimedia.setId(multimediaDTO.getId());
        multimedia.setCreateAt(multimediaDTO.getCreateAt());
        multimedia.setScore(multimediaDTO.getScore());
        multimedia.setImage(multimediaDTO.getImage());
        multimedia.setGenero(map.mappToEntity(multimediaDTO.getGenero()));
        if(multimediaDTO.getPersonaje() != null)
            multimedia.setPersonaje(multimediaDTO.getPersonaje().stream().map(personaje -> this.mapper.mapToEntityId(personaje)).collect(Collectors.toList()));
        return multimedia;
    }
}
