package me.jimmyshaw.animalfacts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalFact {

    private long id;

    private String fact;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
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
