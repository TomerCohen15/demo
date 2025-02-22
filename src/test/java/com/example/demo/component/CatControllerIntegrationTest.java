package com.example.demo.component;

import com.example.demo.entity.Cat;
import com.example.demo.repository.CatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CatRepository catRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        catRepository.deleteAll(); // Clears all records from the table
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    void testCreatecat() throws Exception {
        // Given
        Cat cat = new Cat();
        cat.setName("Whiskers");
        cat.setBreed("Siamese");
        cat.setAge(3);
        cat.setClawSharpness(17);
        String expectedError = "{\"clawSharpness\" : \"must be less than or equal to 10\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        String catJson = objectMapper.writeValueAsString(cat);
        String errorResponse = mockMvc.perform(post("/cats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(catJson))  // Attach the JSON request body
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Then
        JSONAssert.assertEquals(expectedError, errorResponse, false);
        Assertions.assertTrue(catRepository.findAll().isEmpty());
    }

    @Test
    void testGetAllCats() throws Exception {
        // Given
        Cat cat1 = new Cat();
        cat1.setName("Whiskers");
        cat1.setBreed("Siamese");
        cat1.setAge(3);
        cat1.setClawSharpness(7);

        Cat cat2 = new Cat();
        cat2.setName("Garfield");
        cat2.setBreed("Tabby");
        cat2.setAge(5);
        cat2.setClawSharpness(7);

        catRepository.save(cat1); // Save to the test database
        catRepository.save(cat2);

        String actualJson = mockMvc.perform(get("/cats/getAllCats"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        String expectedJson = "[{\"name\":\"Whiskers\",\"breed\":\"Siamese\",\"age\":3,\"clawSharpness\":7},{\"name\":\"Garfield\",\"breed\":\"Tabby\",\"age\":5,\"clawSharpness\":7}]";

        JSONAssert.assertEquals(expectedJson, actualJson, false);
    }
}
