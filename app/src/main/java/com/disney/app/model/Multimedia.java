package com.disney.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "multimedia")
public class Multimedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private Date createAt;
	
	@Column
	private Float score;
	
	@Column
	private String image;

	@ManyToOne(cascade ={ CascadeType.PERSIST ,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
	private Genero genero;

	@ManyToMany(cascade ={ CascadeType.PERSIST ,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
	private List<Personaje> personaje;

}
