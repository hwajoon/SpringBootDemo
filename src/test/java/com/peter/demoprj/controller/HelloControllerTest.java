package com.peter.demoprj.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// https://twofootdog.github.io/Spring-Spring-MVC%EC%97%90%EC%84%9C-JUnit-%ED%99%9C%EC%9A%A9%ED%95%98%EA%B8%B02(MockMvc%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-Controller-%ED%85%8C%EC%8A%A4%ED%8A%B8)/

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    MockMvc mock;

    @Test
    public void testHello() throws Exception {
        mock.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello 스프링부트 !!"));

        MvcResult result = mock.perform(get("/hello"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals("Hello 스프링부트 !!", result.getResponse().getContentAsString());
        assertThat(result.getResponse().getContentAsString()).isEqualTo("Hello 스프링부트 !!");

        System.out.println("PETER>>>" + result.getResponse().getContentAsString());
    }
}