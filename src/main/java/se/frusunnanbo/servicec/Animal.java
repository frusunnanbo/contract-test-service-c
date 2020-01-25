package se.frusunnanbo.servicec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Animal {

    private final static Logger logger = LoggerFactory.getLogger(Animal.class);

    public final String name;
    public final String kind;
    public final String description;
    public final int age;
    public final Image image;
    public final FoodSchedule foodSchedule;

    Animal(String name, String kind, String description, int age, FoodSchedule foodSchedule) {
        this.name = name;
        this.kind = kind;
        this.description = description;
        this.age = age;
        this.image = imageFor(name);
        this.foodSchedule = foodSchedule;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Animal) {
            Animal other = (Animal) o;
            return Objects.equals(this.age, other.age)
                    && Objects.equals(this.foodSchedule, other.foodSchedule)
                    && Objects.equals(this.image, other.image)
                    && Objects.equals(this.kind, other.kind)
                    && Objects.equals(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, age, image, foodSchedule);
    }

    private Image imageFor(String name) {
        return new Image(
                "/images/" + name.toLowerCase() + ".jpg",
                attributionFor(name));
    }

    private String attributionFor(String name) {
            final URL resource = getClass().getClassLoader()
                    .getResource("static/images/" + name.toLowerCase() + "-attribution.txt");
            return Optional.ofNullable(resource).map(r -> resourceContents(resource)).orElse("No attribution found " + resource);
    }

    private String resourceContents(URL resource) {
        try {
            Path path = Paths.get(resource.toURI());
            try (Stream<String> lines = Files.lines(path)) {
                return lines.collect(Collectors.joining("\n"));
            } catch (IOException e) {
                logger.error("Error when reading attribution for {}", resource, e);
                return "Error when reading attribution for " + resource;
            }
        } catch (URISyntaxException e) {
            logger.error("Error when getting attribution for {}", resource, e);
            return "Invalid URI " + resource;
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

    static class FoodSchedule {
        public final String morning;
        public final String lunch;
        public final String evening;

        FoodSchedule(String morning, String lunch, String evening) {
            this.morning = morning;
            this.lunch = lunch;
            this.evening = evening;
        }
    }
}
