package com.disney.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class GeneroDTO {
        private Long id;
        private String name;
        private String image;
        private List<MultimediaDTO> multimedia;
}
