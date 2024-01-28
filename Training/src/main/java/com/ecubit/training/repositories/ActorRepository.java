package com.ecubit.training.repositories;

import com.ecubit.training.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
    Actor findByName(String name);
}
