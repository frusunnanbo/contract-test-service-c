package se.frusunnanbo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
public class ApiController {

    private final List<Stuff> stuffs = Arrays.asList(
            new Stuff("cat", 9),
            new Stuff("dog", 8),
            new Stuff("hedgehog", 76),
            new Stuff("dragon", 93),
            new Stuff("beaver", 73),
            new Stuff("tiger", 23),
            new Stuff("lion", 65)
    );

    @RequestMapping("/stuff")
    public Collection<Stuff> stuff(@RequestParam Optional<String> filter) {
        return stuffs.stream()
                .filter(stuff -> stuff.a.contains(filter.orElse("")))
                .collect(toList());
    }

    private static class Stuff {
        public final OffsetDateTime createdAt;
        public final String a;
        public final int b;

        private Stuff(String a, int b) {
            this.createdAt = OffsetDateTime.now();
            this.a = a;
            this.b = b;
        }
    }

}
