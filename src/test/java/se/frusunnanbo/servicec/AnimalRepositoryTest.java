package se.frusunnanbo.servicec;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static se.frusunnanbo.servicec.Animals.HUFFLEPUFF;
import static se.frusunnanbo.servicec.Animals.SMAUG;

class AnimalRepositoryTest {

    @Test
    public void repository_is_empty_on_start() {
        assertThat(new AnimalRepository().getAll()).isEmpty();
    }

    @Test
    public void setAnimals_can_add_to_empty() {
        final AnimalRepository emptyRepo = new AnimalRepository();
        assertThat(emptyRepo.setAnimals(SMAUG).getAll()).containsExactlyInAnyOrder(SMAUG);
    }

    @Test
    public void setAnimals_can_replace_all_animals_in_repo() {
        final AnimalRepository fullRepo = new AnimalRepository().setAnimals(SMAUG, HUFFLEPUFF);
        assertThat(fullRepo.setAnimals(SMAUG).getAll()).containsExactlyInAnyOrder(SMAUG);
    }
}
