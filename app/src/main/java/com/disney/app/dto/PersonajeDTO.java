package com.disney.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonajeDTO {
    private Long id;
    private String name;
    private Float weigh;
    private Integer age;
    private String history;
    private String image;
    private List<MultimediaDTO> multimedia;
}
