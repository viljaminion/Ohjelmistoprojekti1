package ohjelmistoprojekti.ticketGuru;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohjelmistoprojekti.ticketGuru.domain.TicketType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = { "ADMIN" })
public class TicketTypeEndToEndTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void testTicketTypeWorkflow() throws Exception {

                TicketType ticketType = new TicketType();
                ticketType.setTickettypename("Test Ticket");
                ticketType.setPrice(10.0);

                String ticketTypeJson = new ObjectMapper().writeValueAsString(ticketType);

                MvcResult createResult = mockMvc.perform(post("/tickettypes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(ticketTypeJson))
                                .andExpect(status().isOk())
                                .andReturn();

                TicketType createdTicketType = new ObjectMapper()
                                .readValue(createResult.getResponse().getContentAsString(), TicketType.class);

                MvcResult getResult = mockMvc.perform(get("/tickettype/{id}", createdTicketType.getId()))
                                .andExpect(status().isOk())
                                .andReturn();

                TicketType retrievedTicketType = new ObjectMapper()
                                .readValue(getResult.getResponse().getContentAsString(), TicketType.class);
                assertEquals("Test Ticket", retrievedTicketType.getTickettypename());

                mockMvc.perform(delete("/tickettype/{id}", createdTicketType.getId()))
                                .andExpect(status().isOk());

        }
}
