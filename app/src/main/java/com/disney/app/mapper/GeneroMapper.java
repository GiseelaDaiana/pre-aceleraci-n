package com.disney.app.mapper;

import com.disney.app.dto.GeneroDTO;
import com.disney.app.model.Genero;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
@Service
public class GeneroMapper {

    public Genero mappToEntity(GeneroDTO dto){
        Genero genero = new Genero();
        genero.setId(dto.getId());
        genero.setName(dto.getName());
        genero.setImage(dto.getImage());
        return  genero;
    }
    public GeneroDTO mappToDto(Genero genero){
        GeneroDTO generoDto = new GeneroDTO();
        generoDto.setId(genero.getId());
        generoDto.setName(genero.getName());
        generoDto.setImage(genero.getImage());
        return  generoDto;
    }


}
