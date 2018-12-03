package me.jimmyshaw.animalfacts;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AnimalFactsHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up()
                     .withDetail("message", "Animal Facts HealthIndicator always succeeds")
                     .build();
    }
}
