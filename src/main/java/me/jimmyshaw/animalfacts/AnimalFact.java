package me.jimmyshaw.animalfacts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ANIMAL_FACT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalFact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fact;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(final String fact) {
        this.fact = fact;
    }

    @Override
    public String toString() {
        return String.format("[id=%d,fact=%s]", id, fact);
    }

}
