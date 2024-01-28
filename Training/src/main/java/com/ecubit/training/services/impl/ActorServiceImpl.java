package com.ecubit.training.services.impl;

import com.ecubit.training.models.Actor;
import com.ecubit.training.models.Movie;
import com.ecubit.training.repositories.ActorRepository;
import com.ecubit.training.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;


    @Override
    public List<Movie> getMoviesByActor(String name) {
            Actor actor= actorRepository.findByName(name);
            if(actor!=null){
                return actor.getMovies();
            }else{
                return null;
            }
    }
}
