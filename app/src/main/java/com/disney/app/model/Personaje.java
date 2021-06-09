package com.disney.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Float weigh;
    @Column
    private Integer age;
    @Column
    private String history;
    @Column
    private String image;

    @ManyToMany(mappedBy = "personaje")
    private List<Multimedia> multimedia;


}
