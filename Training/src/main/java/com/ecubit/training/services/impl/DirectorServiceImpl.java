package com.ecubit.training.services.impl;

import com.ecubit.training.models.Director;
import com.ecubit.training.models.Movie;
import com.ecubit.training.repositories.DirectorRepository;
import com.ecubit.training.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {


    @Autowired
    private DirectorRepository directorRepository;


    @Override
    public List<Movie> findMovieByDirector(String name) {
        Director director= directorRepository.findByName(name);
        if(director!=null){
            return director.getMovies();
        }
        throw new RuntimeException();
    }
}
