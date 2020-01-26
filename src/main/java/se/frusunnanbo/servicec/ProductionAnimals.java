package se.frusunnanbo.servicec;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static se.frusunnanbo.servicec.Animals.HUFFLEPUFF;
import static se.frusunnanbo.servicec.Animals.JOY;
import static se.frusunnanbo.servicec.Animals.SMAUG;
import static se.frusunnanbo.servicec.Animals.SPIKY;
import static se.frusunnanbo.servicec.Animals.STRIPEY;
import static se.frusunnanbo.servicec.Animals.TIGGER;

@Component
public class ProductionAnimals implements InitialAnimals {

    @Override
    public Collection<Animal> get() {
        return List.of(
                HUFFLEPUFF,
                SPIKY,
                JOY,
                SMAUG,
                STRIPEY,
                TIGGER);
    }
}
