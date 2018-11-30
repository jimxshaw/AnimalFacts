package me.jimmyshaw.animalfacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class AnimalFactsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalFactsController.class);

    private final AnimalFactsRepository repository;

    public AnimalFactsController(final AnimalFactsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/facts", method = RequestMethod.GET)
    public AnimalServiceResponse facts() {
        LOGGER.info("Request received for [/facts]");

        final AnimalServiceResponse response = new AnimalServiceResponse();

        response.setType("success");

        final List<AnimalFact> facts = StreamSupport.stream(repository.findAll().spliterator(), false)
                                                    .collect(Collectors.toList());

        response.setValue(facts);

        return response;
    }

    @RequestMapping(value = "/facts/{factId}", method = RequestMethod.GET)
    public AnimalServiceResponse fact(@PathVariable("factId") final Long id) {
        LOGGER.info("Request received for [/facts/{factId}]");

        final AnimalServiceResponse response = new AnimalServiceResponse();

        response.setType("success");

        final List<AnimalFact> facts = new ArrayList<>();

        repository.findById(id).ifPresent(facts::add);

        response.setValue(facts);

        return response;
    }

    public static class AnimalServiceResponse {
        private String type;

        private List<AnimalFact> value;

        public String getType() {
            return type;
        }

        public void setType(final String type) {
            this.type = type;
        }

        public List<AnimalFact> getValue() {
            return value;
        }

        public void setValue(final List<AnimalFact> value) {
            this.value = value;
        }
    }

}
