package me.jimmyshaw.animalfacts;

import org.springframework.data.repository.CrudRepository;

public interface AnimalFactsRepository extends CrudRepository<AnimalFact, Long> {
    
}

