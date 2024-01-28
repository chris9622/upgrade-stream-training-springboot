package com.ecubit.training.controllers;

import com.ecubit.training.models.Movie;
import com.ecubit.training.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;


@RequestMapping("/movie")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        movieService.insertMovieFromCsv(file);
        return ResponseEntity.ok("File CSV caricato con successo e dati inseriti nel database.");
    }



    @GetMapping("/sorted-by-year")
    public ResponseEntity<List<Movie>> getMoviesSortedByYear() {
        List<Movie> movies = movieService.getMovieByYear();
            return ResponseEntity.ok(movies);
    }

    @GetMapping("/sorted-by-title")
    public ResponseEntity<List<Movie>> getMoviesSortedByTitle() {
        List<Movie> movies = movieService.getMovieByTitle();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/sorted-by-rating-and-title")
    public ResponseEntity<List<Movie>> getMoviesSortedByRatingAndTitle(){
        List<Movie> movies = movieService.findMoviesByRatingAndTitle();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/sorted-by-duration-and-year")
    public ResponseEntity<List<Movie>> getMoviesSortedByDurationAndYear(){
        List<Movie> movies = movieService.findMoviesByDurationAndYear();
        return ResponseEntity.ok(movies);
    }




}
