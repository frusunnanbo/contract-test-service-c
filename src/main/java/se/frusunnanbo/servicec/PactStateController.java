package se.frusunnanbo.servicec;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static se.frusunnanbo.servicec.Animals.HUFFLEPUFF;
import static se.frusunnanbo.servicec.Animals.JOY;
import static se.frusunnanbo.servicec.Animals.SPIKY;

@RestController
public class PactStateController {

    Logger logger = LoggerFactory.getLogger(PactStateController.class);
    private final AnimalRepository animalRepository;

    public PactStateController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostMapping("/pactStateChange")
    public String setPactState(@RequestBody State state) {
        logger.info("Got request to change state to '{}'", state.state);
        if ("there are 2 hedgehogs and 1 cat".equals(state.state)) {
            logger.info("1 cat, two hedgehogs");
            animalRepository.setAnimals(SPIKY, JOY, HUFFLEPUFF);
        }

        return "OK";
    }

    private static class State {
        private String state;

        @JsonCreator
        public State(@JsonProperty("state") String state) {
            this.state = state;
        }
    }
}
