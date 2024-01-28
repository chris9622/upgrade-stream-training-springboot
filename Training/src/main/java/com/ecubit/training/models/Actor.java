package com.ecubit.training.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idActor;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "actors")
    private List<Movie> movies = new ArrayList<>();

    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, List<Movie> movies) {
        this.name=name;
        this.movies=movies;
    }
}
