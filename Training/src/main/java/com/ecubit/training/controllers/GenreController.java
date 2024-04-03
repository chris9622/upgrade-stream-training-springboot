package com.ecubit.training.controllers;

import com.ecubit.training.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/genre")
@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGenereById(@PathVariable("id") long id) {
        try {
            genreService.deleteGenereById(id);
            return new ResponseEntity<>("Genere eliminato", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore nell'eliminazione di un genere: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
