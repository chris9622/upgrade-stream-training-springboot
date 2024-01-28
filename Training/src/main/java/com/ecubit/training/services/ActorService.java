package com.ecubit.training.services;

import com.ecubit.training.models.Movie;

import java.util.List;

public interface ActorService {

    List<Movie> getMoviesByActor(String name);
}
