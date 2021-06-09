package com.disney.app.repository;
import com.disney.app.model.Multimedia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia,Long> {
    @Query("select m from Multimedia m left join m.genero g where(?1 is null or m.title=?1) and (?2 is null or g.id=?2)")
    List<Multimedia> findByNameAndIdGenero(String title, Long id, Sort sort);
}