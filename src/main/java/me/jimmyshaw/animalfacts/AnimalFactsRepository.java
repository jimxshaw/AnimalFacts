package me.jimmyshaw.animalfacts;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AnimalFactsRepository {
    private final List<AnimalFact> facts = new ArrayList<>();

    public AnimalFactsRepository() {
        facts.add(createFact(1L, "Prairie dogs greet one another by kissing"));
        facts.add(createFact(2L, "Anteaters don't have teeth"));
    }

    private AnimalFact createFact(final Long id, final String fact) {
        final AnimalFact animalFact = new AnimalFact();
        animalFact.setId(id);
        animalFact.setFact(fact);

        return animalFact;
    }

    public Iterable<AnimalFact> findAll() {
        return Collections.unmodifiableList(facts);
    }

    public Optional<AnimalFact> findById(final Long id) {
        for (final AnimalFact fact : facts) {
            if (id.equals(fact.getId())) {
                return Optional.of(fact);
            }
        }

        return Optional.empty();
    }

}
