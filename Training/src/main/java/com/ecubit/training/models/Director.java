package com.ecubit.training.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director")
    private long idDirector;

    @Column(name = "name_director")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "directors")
    private List<Movie> movies= new ArrayList<>();

    public Director(String nameDirector) {
        this.name = nameDirector;
    }
}
