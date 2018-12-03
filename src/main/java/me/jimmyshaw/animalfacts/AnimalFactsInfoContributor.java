package me.jimmyshaw.animalfacts;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class AnimalFactsInfoContributor implements InfoContributor {

    private static final LocalDate ANIMAL_FACTS_DATE_OF_CREATION = LocalDate.of(2018, 11, 30);

    @Override
    public void contribute(final Info.Builder builder) {
        builder.withDetail("animalFactsAge", Period.between(ANIMAL_FACTS_DATE_OF_CREATION, LocalDate.now()).getYears());
    }
}
