package com.ecubit.training.controllers;

import com.ecubit.training.models.Movie;
import com.ecubit.training.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/director")
@RestController
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@RequestParam String name){
        List<Movie> movies=directorService.findMovieByDirector(name);
        return  ResponseEntity.ok(movies);
    }
}
