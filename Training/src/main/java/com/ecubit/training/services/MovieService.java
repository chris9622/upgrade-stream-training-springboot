package com.ecubit.training.services;

import com.ecubit.training.models.Movie;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


public interface MovieService {

    void insertMovieFromCsv(MultipartFile file);

    List<Movie> getMovieByYear();

    List<Movie> getMovieByTitle();

    List<Movie> findMoviesByRatingAndTitle();

    List<Movie> findMoviesByDurationAndYear();






}
