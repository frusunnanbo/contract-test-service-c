package se.frusunnanbo.servicec.contracts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import se.frusunnanbo.servicec.AnimalRepository;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static se.frusunnanbo.servicec.Animals.HUFFLEPUFF;
import static se.frusunnanbo.servicec.Animals.JOY;
import static se.frusunnanbo.servicec.Animals.SPIKY;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceAContractTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalRepository animalRespository;

    @Test
    public void should_return_expected_json_format() throws Exception {
        given(animalRespository.getAll()).willReturn(List.of(HUFFLEPUFF));

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].name").isString())
                .andExpect(jsonPath("$[0].image.path").isString())
                .andExpect(jsonPath("$[0].description").isString())
                .andExpect(jsonPath("$[0].age").isNumber());
    }

    @Test
    public void should_filter_animals_by_kind() throws Exception {
        given(animalRespository.getAll()).willReturn(List.of(SPIKY, HUFFLEPUFF, JOY));

        this.mockMvc.perform(get("/?kind=hedgehog"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0]").isMap())
                .andExpect(jsonPath("$[0].kind").value("hedgehog"))
                .andExpect(jsonPath("$[1]").isMap())
                .andExpect(jsonPath("$[1].kind").value("hedgehog"))
                .andExpect(jsonPath("$[2]").doesNotExist());
    }
}
