package se.frusunnanbo.servicec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static se.frusunnanbo.servicec.Animals.HUFFLEPUFF;
import static se.frusunnanbo.servicec.Animals.JOY;
import static se.frusunnanbo.servicec.Animals.SMAUG;
import static se.frusunnanbo.servicec.Animals.SPIKY;
import static se.frusunnanbo.servicec.Animals.STRIPEY;
import static se.frusunnanbo.servicec.Animals.TIGGER;

@RestController
public class AnimalController {

    Logger logger = LoggerFactory.getLogger(AnimalController.class);
    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
        this.repository.setAnimals(
                HUFFLEPUFF,
                SPIKY,
                JOY,
                SMAUG,
                STRIPEY,
                TIGGER);
    }

    @RequestMapping("/animals")
    public Collection<Animal> animals(@RequestParam Optional<String> kind) {
        logger.info("Got request for /animals");
        return repository.getAll().stream()
                .filter(animal -> animal.kind.contains(kind.orElse("")))
                .collect(toList());
    }

}
