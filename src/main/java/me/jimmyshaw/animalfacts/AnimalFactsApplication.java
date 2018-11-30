package me.jimmyshaw.animalfacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimalFactsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnimalFactsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AnimalFactsApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedFacts(final AnimalFactsRepository repository) {
		return args -> {
			repository.save(createFact("Cats don't have the taste buds to taste sweet foods"));
			repository.save(createFact("Birds are immune to the heat of chili peppers"));
			repository.save(createFact("Wombat dropings are shaped like cubes"));
			repository.save(createFact("A platypus produces venom"));
			repository.save(createFact("A grizzly bear's bite can crush a bowling ball"));

			for (final AnimalFact fact : repository.findAll()) {
				LOGGER.info("Loaded: [{}]", fact);
			}
		};
	}

	private AnimalFact createFact(final String fact) {
		final AnimalFact animalFact = new AnimalFact();

		animalFact.setFact(fact);

		return animalFact;
	}

}
