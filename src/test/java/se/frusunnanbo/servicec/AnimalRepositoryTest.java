package se.frusunnanbo.servicec;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static se.frusunnanbo.servicec.Animals.HUFFLEPUFF;
import static se.frusunnanbo.servicec.Animals.SMAUG;

class AnimalRepositoryTest {

    @Test
    public void repository_is_empty_on_start() {
        assertThat(new AnimalRepository(animals()).getAll()).isEmpty();
    }

    @Test
    public void setAnimals_can_add_to_empty() {
        final AnimalRepository emptyRepo = new AnimalRepository(animals());
        assertThat(emptyRepo.setAnimals(SMAUG).getAll()).containsExactlyInAnyOrder(SMAUG);
    }

    @Test
    public void setAnimals_can_replace_all_animals_in_repo() {
        final AnimalRepository fullRepo = new AnimalRepository(animals(SMAUG, HUFFLEPUFF));
        assertThat(fullRepo.setAnimals(SMAUG).getAll()).containsExactlyInAnyOrder(SMAUG);
    }

    private static InitialAnimals animals(Animal... animals) {
        return () -> List.of(animals);
    }
}
