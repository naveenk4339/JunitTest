package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    UserService servcie;

    @Test
    public void createUser_whenCalled_returns_201_CREATED() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new UserRequest().setFirstName("Trader").setLastName("Joe"))))
                .andExpect(status().isCreated());
    }

    @Test
    public void createUser_whenCalled_returns_201_CREATED_and_UID() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new UserRequest().setFirstName("Trader").setLastName("Joe"))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", Is.is("abc")));
    }

    @Test
    public void createUser_whenCalled_returns_201_CREATED_and__new_UID() throws Exception {

        when(servcie.create(any(UserRequest.class))).thenReturn("xyz");
        mvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new UserRequest().setFirstName("Produce").setLastName("Joe"))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", Is.is("xyz")));
    }


}
