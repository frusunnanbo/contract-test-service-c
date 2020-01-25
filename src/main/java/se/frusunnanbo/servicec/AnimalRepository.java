package se.frusunnanbo.servicec;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AnimalRepository {
    private final List<Animal> animals = new CopyOnWriteArrayList<Animal>();

    public Collection<Animal> getAll() {
        return List.copyOf(animals);
    }

    public AnimalRepository setAnimals(Animal... animals) {
        this.animals.clear();
        this.animals.addAll(List.of(animals));
        return this;
    }
}
