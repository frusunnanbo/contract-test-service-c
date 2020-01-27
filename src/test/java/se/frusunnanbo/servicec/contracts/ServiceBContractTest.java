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

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceBContractTest {

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
                .andExpect(jsonPath("$[0].foodSchedule").isMap())
                .andExpect(jsonPath("$[0].foodSchedule.morning").isString())
                .andExpect(jsonPath("$[0].foodSchedule.lunch").isString())
                .andExpect(jsonPath("$[0].foodSchedule.evening").isString());
    }
}
