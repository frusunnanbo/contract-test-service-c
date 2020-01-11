package se.frusunnanbo.servicec;

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

    private final List<Animal> animals = Arrays.asList(
            new Animal("Hufflepuff", "cat", 9, "Only awake at night"),
            new Animal("Taco", "dog", 8, "Loves bathing"),
            new Animal("Spiky", "hedgehog", 7, "Absolutely hates milk"),
            new Animal("Joy", "hedgehog", 4, "Eats snails"),
            new Animal("Smaug", "dragon", 93, "Loves to be schratched on his belly"),
            new Animal("Betty", "beaver", 23, "Hides for strangers"),
            new Animal("Stripey McBitealot", "tiger", 17, "Probably the world's only vegetarian tiger"),
            new Animal("Tigger Longwhiskers", "tiger", 10, "Born and bred in New York"),
            new Animal("Simba", "lion", 4, "Loves biting little girls")
    );

    @RequestMapping("/animals")
    public Collection<Animal> animals(@RequestParam Optional<String> filter) {
        System.out.println("Got request for /animals");
        return animals.stream()
                .filter(animal -> animal.kind.contains(filter.orElse("")))
                .collect(toList());
    }

    private static class Animal {
        public final String name;
        public final String kind;
        public final int age;
        public final String funFact;

        private Animal(String name, String kind, int age, String funFact) {
            this.name = name;
            this.kind = kind;
            this.age = age;
            this.funFact = funFact;
        }
    }

}
