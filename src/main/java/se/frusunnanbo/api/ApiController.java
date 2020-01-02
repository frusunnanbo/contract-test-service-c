package se.frusunnanbo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
public class ApiController {

    private final List<Stuff> stuffs = Arrays.asList(
            new Stuff("Hufflepuff", "cat", 9),
            new Stuff("Taco", "dog", 8),
            new Stuff("Spiky", "hedgehog", 7),
            new Stuff("Joy", "hedgehog", 4),
            new Stuff("Smaug", "dragon", 93),
            new Stuff("Betty", "beaver", 23),
            new Stuff("Stripey McBitealot", "tiger", 17),
            new Stuff("Tigger Longwhiskers", "tiger", 10),
            new Stuff("Simba", "lion", 4)
    );

    @RequestMapping("/animals")
    public Collection<Stuff> animals(@RequestParam Optional<String> filter) {
        System.out.println("Got request for /animals");
        return stuffs.stream()
                .filter(stuff -> stuff.kind.contains(filter.orElse("")))
                .collect(toList());
    }

    private static class Stuff {
        public final String name;
        public final String kind;
        public final int age;

        private Stuff(String name, String kind, int age) {
            this.name = name;
            this.kind = kind;
            this.age = age;
        }
    }

}
