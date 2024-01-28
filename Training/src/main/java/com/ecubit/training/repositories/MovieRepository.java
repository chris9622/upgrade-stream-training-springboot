package com.ecubit.training.repositories;

import com.ecubit.training.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {


  List<Movie> findAllByOrderByYearAsc();

  List<Movie> findAllByOrderByTitleAsc();

  @Query(value = "Select * from movies order by rating,title asc",nativeQuery = true)
  List<Movie> findAllByOrderByRatingAndTitleAsc();

  //Si potrebbe scrivere anche findAllOderByRatingAscTitleAsc

  @Query(value = "Select * from movies order by duration,year asc",nativeQuery = true)
  List<Movie> findAllByOrderByDurationAndByYear();





}
