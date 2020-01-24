package se.frusunnanbo.servicec;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PactStateController {


    @PostMapping(value = "/pactStateChange")
    public String setPactState(@RequestBody State state) {
        if ("there are 2 hedgehogs and 1 cat".equals(state.state)) {
            System.out.println("1 cat, two hedgehogs");
        }

        System.out.println("hej!");
        return "OK";
    }

    private static class State {
        private String state;
    }
}