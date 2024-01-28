package com.ecubit.training.services.impl;

import com.ecubit.training.models.Actor;
import com.ecubit.training.models.Director;
import com.ecubit.training.models.Genre;
import com.ecubit.training.models.Movie;
import com.ecubit.training.repositories.ActorRepository;
import com.ecubit.training.repositories.DirectorRepository;
import com.ecubit.training.repositories.GenreRepository;
import com.ecubit.training.repositories.MovieRepository;
import com.ecubit.training.services.MovieService;
import com.ecubit.training.tmdb.ImdbLoader;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private GenreRepository genreRepository;


    @Override
    @Transactional
    public void insertMovieFromCsv(MultipartFile file) {
        try {
            List<Movie> movies = ImdbLoader.loadMovies();

          for (Movie movie : movies) {
              List<Actor> actorList= new ArrayList<>();
              for (Actor actor : movie.getActors()) {
                  Actor existingActor= actorRepository.findByName(actor.getName());
                  if(existingActor==null){
                      Actor a= new Actor(actor.getName());
                      actorRepository.save(a);
                      actorList.add(a);
                  }else{
                      actorList.add(existingActor);
                  }
              }
              movie.setActors(actorList);

              List<Genre> genreList= new ArrayList<>();
              for(Genre genre: movie.getGenres()){
                  Genre existingGenre= genreRepository.findByTypeGenre(genre.getTypeGenre());
                  if(existingGenre==null){
                      Genre g= new Genre(genre.getTypeGenre());
                      genreList.add(genreRepository.save(g));
                  }else{
                      genreList.add(existingGenre);
                  }
              }
              movie.setGenres(genreList);

              List<Director> directorList= new ArrayList<>();
              for(Director director:movie.getDirectors()){
                  Director existingDirector= directorRepository.findByName(director.getName());
                  if(existingDirector==null) {
                      Director d= new Director(director.getName());
                      directorList.add(directorRepository.save(d));
                  }else{
                      directorList.add(existingDirector);
                  }
              }
              movie.setDirectors(directorList);

               Movie movieTosaved = movieRepository.save(movie);

           }

        } catch (Exception e) {
            log.error("Si è verificato un errore durante l'inserimento dei film: " + e.getMessage());
            throw new RuntimeException("Errore durante l'inserimento dei film", e);
        }
    }



    @Override
    public List<Movie> getMovieByYear()  {
        try {
            List<Movie> output = new ArrayList<>();
            output.addAll(movieRepository.findAllByOrderByYearAsc());
            return output;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Movie> getMovieByTitle() {
        try {
            List<Movie> output= new ArrayList<>();
            output.addAll(movieRepository.findAllByOrderByTitleAsc());
                    return output;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Movie> findMoviesByRatingAndTitle() {
        try{
            return movieRepository.findAllByOrderByRatingAndTitleAsc();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Movie> findMoviesByDurationAndYear() {
        try{
            return movieRepository.findAllByOrderByDurationAndByYear();
        }catch (Exception e){
            throw e;
        }
    }


}
