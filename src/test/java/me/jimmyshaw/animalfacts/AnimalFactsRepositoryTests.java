package me.jimmyshaw.animalfacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnimalFactsRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnimalFactsRepository animalFactsRepository;

    @Test
    public void findById() {
        final AnimalFact factToInsert = new AnimalFact();
        factToInsert.setFact("Test Fact");
        entityManager.persist(factToInsert);

        final Optional<AnimalFact> factFromDb = animalFactsRepository.findById(factToInsert.getId());

        assertThat(factFromDb.isPresent()).isTrue();
        assertThat(factFromDb.get().getId()).isEqualTo(factToInsert.getId());
        assertThat(factFromDb.get().getFact()).isEqualTo("Test Fact");
    }
}
