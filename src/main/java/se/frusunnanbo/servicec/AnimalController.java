package se.frusunnanbo.servicec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
public class AnimalController {

    Logger logger = LoggerFactory.getLogger(AnimalController.class);

    private final List<Animal> animals = Arrays.asList(
            Animals.HUFFLEPUFF,
            Animals.TACO,
            Animals.SPIKY,
            Animals.JOY,
            Animals.SMAUG,
            Animals.BETTY,
            Animals.STRIPEY,
            Animals.TIGGER,
            Animals.SIMBA
    );

    @RequestMapping("/animals")
    public Collection<Animal> animals(@RequestParam Optional<String> filter) {
        logger.info("Got request for /animals");
        return animals.stream()
                .filter(animal -> animal.kind.contains(filter.orElse("")))
                .collect(toList());
    }

}
