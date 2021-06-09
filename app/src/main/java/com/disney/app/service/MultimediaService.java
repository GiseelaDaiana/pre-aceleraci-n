package com.disney.app.service;

import com.disney.app.dto.MultimediaDTO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MultimediaService {

    MultimediaDTO getDetail(Long id);

    Long crear(MultimediaDTO dto);

    Long update(MultimediaDTO dto);

    Long delete(Long id);

    List<MultimediaDTO> filter(String title, Long id, Sort.Direction order);
}
