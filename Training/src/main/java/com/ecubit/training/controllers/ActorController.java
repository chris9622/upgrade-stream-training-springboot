package com.ecubit.training.controllers;

import com.ecubit.training.models.Movie;
import com.ecubit.training.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/actor")
@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/get")
    public ResponseEntity<List<Movie>> moviesByActorName(@RequestParam String name){
        List<Movie> movies=actorService.getMoviesByActor(name);
        return  ResponseEntity.ok(movies);
    }
}
