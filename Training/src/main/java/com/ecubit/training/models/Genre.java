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
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private long idGenre;

    @Column(name = "type_genre")
    private String typeGenre;

   @ManyToMany(fetch = FetchType.LAZY,
           mappedBy = "genres")
   private List<Movie> movies= new ArrayList<>();


    public Genre(String typeGenre) {
        this.typeGenre = typeGenre;
    }
}
