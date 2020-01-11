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
            new Animal("Hufflepuff", "cat", 9, "Only awake at night", new FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Taco", "dog", 8, "Loves bathing", new FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Spiky", "hedgehog", 7, "Absolutely hates milk", new FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Joy", "hedgehog", 4, "Eats snails", new FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Smaug", "dragon", 93, "Loves to be schratched on his belly", new FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Betty", "beaver", 23, "Hides for strangers", new FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Stripey McBitealot", "tiger", 17, "Probably the world's only vegetarian tiger", new FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Tigger Longwhiskers", "tiger", 10, "Born and bred in New York", new FoodSchedule("Nothing", "Nothing", "Steak")),
            new Animal("Simba", "lion", 4, "Loves biting little girls", new FoodSchedule("Nothing", "Nothing", "Steak"))
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
        public final Image image;
        public final String funFact;
        public final FoodSchedule foodSchedule;

        private Animal(String name, String kind, int age, String funFact, FoodSchedule foodSchedule) {
            this.name = name;
            this.kind = kind;
            this.age = age;
            this.image = imageFor(name);
            this.funFact = funFact;
            this.foodSchedule = foodSchedule;
        }

        private Image imageFor(String name) {
            return new Image("/images/" + name.toLowerCase() + ".jpg", "/images/" + name.toLowerCase() + "-attribution.jpg");
        }
    }

    private static class Image {
        public final String path;
        public final String attribution;

        private Image(String path, String attribution) {
            this.path = path;
            this.attribution = attribution;
        }
    }

    private static class FoodSchedule {
        public final String morning;
        public final String lunch;
        public final String evening;

        private FoodSchedule(String morning, String lunch, String evening) {
            this.morning = morning;
            this.lunch = lunch;
            this.evening = evening;
        }
    }
}
