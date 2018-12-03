package me.jimmyshaw.animalfacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnimalFactsControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private AnimalFactsRepository animalFactsRepository;

    @Test
    public void testFacts() {
        given(animalFactsRepository.findAll()).willReturn(Collections.singletonList(animalFact(999L, "Test Fact")));

        final AnimalFactsController.AnimalServiceResponse response = restTemplate.getForObject("/api/facts", AnimalFactsController.AnimalServiceResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getType()).isEqualTo("success");
        assertThat(response.getValue().get(0).getId()).isEqualTo(999L);
        assertThat(response.getValue().get(0).getFact()).isEqualTo("Test Fact");
    }

    @Test
    public void testFactsById() {
        given(animalFactsRepository.findById(999L)).willReturn(Optional.of(animalFact(999L, "Test Fact")));

        final AnimalFactsController.AnimalServiceResponse response = restTemplate.getForObject("/api/facts/999", AnimalFactsController.AnimalServiceResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getType()).isEqualTo("success");
        assertThat(response.getValue().get(0).getId()).isEqualTo(999L);
        assertThat(response.getValue().get(0).getFact()).isEqualTo("Test Fact");
    }

    private AnimalFact animalFact(final Long id, final String fact) {
        final AnimalFact animalFact = new AnimalFact();
        animalFact.setId(id);
        animalFact.setFact(fact);

        return animalFact;
    }
}
