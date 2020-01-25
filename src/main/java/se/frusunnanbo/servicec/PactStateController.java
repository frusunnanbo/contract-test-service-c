package se.frusunnanbo.servicec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PactStateController {

    Logger logger = LoggerFactory.getLogger(PactStateController.class);

    @PostMapping(value = "/pactStateChange")
    public String setPactState(@RequestBody State state) {
        if ("there are 2 hedgehogs and 1 cat".equals(state.state)) {
            logger.info("1 cat, two hedgehogs");
        }

        logger.info("hej!");
        return "OK";
    }

    private static class State {
        private String state;
    }
}
