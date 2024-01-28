package com.ecubit.training.services;

import com.ecubit.training.models.Director;
import com.ecubit.training.models.Movie;

import java.util.List;

public interface DirectorService {

    List<Movie> findMovieByDirector(String name);
}
