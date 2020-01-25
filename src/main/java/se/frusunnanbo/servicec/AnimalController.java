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
            new Animal("Hufflepuff", "cat", 9, "Only awake at night", new Animal.FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Taco", "dog", 8, "Loves bathing", new Animal.FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Spiky", "hedgehog", 7, "Absolutely hates milk", new Animal.FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Joy", "hedgehog", 4, "Eats snails", new Animal.FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Smaug", "dragon", 93, "Loves to be schratched on his belly", new Animal.FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Betty", "beaver", 23, "Hides for strangers", new Animal.FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Stripey McBitealot", "tiger", 17, "Probably the world's only vegetarian tiger", new Animal.FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Tigger Longwhiskers", "tiger", 10, "Born and bred in New York", new Animal.FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Simba", "lion", 4, "Loves biting little girls", new Animal.FoodSchedule("Nothing", "Nothing", "Steak"))
    );

    @RequestMapping("/animals")
    public Collection<Animal> animals(@RequestParam Optional<String> filter) {
        logger.info("Got request for /animals");
        return animals.stream()
                .filter(animal -> animal.kind.contains(filter.orElse("")))
                .collect(toList());
    }

}
