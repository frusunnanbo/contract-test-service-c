package se.frusunnanbo.servicec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
public class AnimalController {

    Logger logger = LoggerFactory.getLogger(AnimalController.class);
    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public Collection<Animal> animals(@RequestParam Optional<String> kind) {
        logger.info("Got request for /");
        return repository.getAll().stream()
                .filter(animal -> animal.kind.contains(kind.orElse("")))
                .collect(toList());
    }
}
