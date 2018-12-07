package me.jimmyshaw.animalfacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class AnimalFactsIndexController {

    private final AnimalFactsRepository repository;

    @Autowired
    public AnimalFactsIndexController(final AnimalFactsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(final Map<String, Object> model) {
        model.put("facts", repository.findAll());

        return "index";
    }

}
