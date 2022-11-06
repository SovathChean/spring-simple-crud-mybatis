package com.mybatisgenerator.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatisgenerator.crud.helper.ResultCodeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties" )
public class AbstractTestCase {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    protected String toJson(Object data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }

    public ResultActions callPostAPI(String endpoint, Object requestData, ResultCodeType resultCodeType) throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .post(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("user-id", "unit-test")
                .content(toJson(requestData));

        return assertion(builder, resultCodeType);
    }
    public ResultActions callPutAPI(String endpoint, Object requestData, ResultCodeType resultCodeType) throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .put(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("user-id", "unit-test")
                .content(toJson(requestData));

        return assertion(builder, resultCodeType);
    }
    public ResultActions callDeleteAPI(String endpoint, ResultCodeType resultCodeType) throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .delete(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("user-id", "unit-test");

        return assertion(builder, resultCodeType);
    }
    public ResultActions callGetAPI(String endpoint, ResultCodeType resultCodeType) throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("user-id", "unit-test");

        return assertion(builder, resultCodeType);
    }

    public ResultActions assertion(RequestBuilder builder, ResultCodeType resultCodeType) throws Exception {
        ResultActions response = mockMvc.perform(builder).andDo(MockMvcResultHandlers.print());

        if(resultCodeType != null)
            response.andExpect(status().is4xxClientError())
                    .andExpect(jsonPath("$.result").value(false))
                    .andExpect(jsonPath("$.result_code").value(HttpStatus.BAD_REQUEST.toString()))
                    .andExpect(jsonPath("$.result_message").value("fail"));

        else
            response.andExpect(status().isOk())
                    .andExpect(jsonPath("$.result").value(true))
                    .andExpect(jsonPath("$.result_code").value(HttpStatus.OK.toString()))
                    .andExpect(jsonPath("$.result_message").value("success"));

        return response;
    }
}
