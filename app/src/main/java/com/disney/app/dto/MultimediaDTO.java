package com.disney.app.dto;

import com.disney.app.model.Genero;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultimediaDTO {

    private Long id;
    private String title;
    private Date createAt;
    private Float score;
    private String image;
    private GeneroDTO genero;
    private List<PersonajeDTO> personaje;

}
