package com.disney.app.repository;

import com.disney.app.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonajeRepository extends JpaRepository<Personaje,Long> {

    @Query("select p from Personaje p join p.multimedia m where  (?1 is null or p.name=?1) and (?2 is null or p.age=?2) and (?3 is null or m.id=?3)")
    List<Personaje> findByNameAndAge(String name,Integer age,Long id);
}
