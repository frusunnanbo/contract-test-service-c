package se.frusunnanbo.servicec;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class AnimalRepository {
    private final AtomicReference<List<Animal>> animals;

    public AnimalRepository(InitialAnimals initial) {
        animals = new AtomicReference<>(List.copyOf(initial.get()));
    }
    public Collection<Animal> getAll() {
        return List.copyOf(animals.get());
    }

    public AnimalRepository setAnimals(Animal... animals) {
        this.animals.getAndSet(List.of(animals));
        return this;
    }
}
