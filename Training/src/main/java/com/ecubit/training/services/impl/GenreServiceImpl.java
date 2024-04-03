package com.ecubit.training.services.impl;

import com.ecubit.training.repositories.GenreRepository;
import com.ecubit.training.services.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;


    @Override
    public void deleteGenereById(long id) {
        try{
            genreRepository.deleteById(id);
            log.info("Genere eliminato");
        }catch (Exception e){
            log.error("Errore nell'eliminazione di un genere" + e.getMessage());
        }
    }
}
