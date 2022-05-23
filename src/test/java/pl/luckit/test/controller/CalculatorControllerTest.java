package pl.luckit.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.luckit.test.exception.ExceptionMessageEnum.INVALID_INPUT_MESSAGE_PAGE;

@SpringBootTest
class CalculatorControllerTest {

    private static final String ADD_ENDPOINT = "/add?val1={val1}&val2={val2}";
    private static final String DIV_ENDPOINT = "/div?val1={val1}&val2={val2}";

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void shouldCallAddEndpointAndReturn200StatusAndExpectedResultValue() throws Exception {
        mockMvc.perform(post(ADD_ENDPOINT, 10.20, 11.22)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("result", is(21.42)));
    }

    @Test
    void shouldCallAddEndpointAndReturn406StatusAndErrorMessage() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(post(ADD_ENDPOINT, 10.20, null)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(HttpStatus.NOT_ACCEPTABLE.value()))
                .andReturn();

        String contentMessage = mvcResult.getResponse().getContentAsString();

        //then
        assertThat(contentMessage).isEqualTo(INVALID_INPUT_MESSAGE_PAGE.getMessage());
    }

    @Test
    void shouldCallDivEndpointReturn200StatusAndExpectedResultValue() throws Exception {
        mockMvc.perform(get(DIV_ENDPOINT, 10.0, 2.0))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("result", is(5.0)));
    }

    @Test
    void shouldCallDivEndpointAndReturn406StatusAndErrorMessage() throws Exception {
        //given
        //when
        MvcResult mvcResult = mockMvc.perform(get(DIV_ENDPOINT, 10.0, 0.0))
                .andDo(print())
                .andExpect(status().is(HttpStatus.NOT_ACCEPTABLE.value()))
                .andReturn();

        String contentMessage = mvcResult.getResponse().getContentAsString();

        //then
        assertThat(contentMessage).isEqualTo(INVALID_INPUT_MESSAGE_PAGE.getMessage());
    }

    @Test
    void shouldReturn404StatusForWrongPath() throws Exception {
        mockMvc.perform(get("/wrongPath"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
    }
}