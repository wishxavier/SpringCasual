package org.wish.spring.democonfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wish.spring.democonfiguration.model.LegoItem;

@SpringBootTest
@AutoConfigureMockMvc
class DemoConfigurationApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLegoConfigurationProperties() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/lego"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"name\":\"花束\",\"number\":10280,\"pieces\":756}"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testPutLegoItem() throws Exception {
        var legoItem = new LegoItem();
        legoItem.setName("2022 Ford GT");
        legoItem.setNumber(42154);
        legoItem.setPieces(1466);

        mockMvc.perform(MockMvcRequestBuilders.put("/lego")
                        .content(new ObjectMapper().writeValueAsString(legoItem))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(legoItem.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").value(legoItem.getNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pieces").value(legoItem.getPieces()))
                .andDo(MockMvcResultHandlers.print());
    }
}
