package com.disney.app.service;

import com.disney.app.dto.MultimediaDTO;
import com.disney.app.mapper.MultimediaMapper;
import com.disney.app.model.Multimedia;
import com.disney.app.repository.MultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MultimediaServiceImpl implements MultimediaService {
    public static final String DEFAULT_COLUMN_ORDER = "title";
    @Autowired
    MultimediaRepository repository;
    @Autowired
    MultimediaMapper mapper;


    public MultimediaDTO getDetail(Long id) {
        Optional<Multimedia> multimedia = repository.findById(id);
        return multimedia.map(value -> mapper.mapAllWithPersonaje(value)).orElse(null);
    }

    @Override
    public Long crear(MultimediaDTO dto) {
        Multimedia multimedia = repository.save(mapper.mapToEntity(dto));
        return multimedia.getId();
    }

    @Override
    public Long update(MultimediaDTO dto) {
        Optional<Multimedia> multimedia = repository.findById(dto.getId());
        if ( multimedia.isPresent() ){
            Multimedia newMultimedia = mapper.mapToEntity(dto);
            newMultimedia.setId(dto.getId());
            repository.save(newMultimedia);
            return newMultimedia.getId();
        }
        return  null;
    }

    @Override
    public Long delete(Long id) {
        Optional<Multimedia> multimedia = repository.findById(id);
        if (multimedia.isPresent()) {
            repository.deleteById(id);
            return multimedia.get().getId();
        }
        return null ;
    }

    @Override
    public List<MultimediaDTO> filter(String title, Long id, Sort.Direction order) {
        List<Multimedia> multimedia = repository.findByNameAndIdGenero(title,id, Sort.by(order, DEFAULT_COLUMN_ORDER));
        return multimedia.stream().map(p -> mapper.mapMovies(p)).collect(Collectors.toList());
    }



}
